/**
 ******************************************************************************
 * $Id: Expression.java 23 2013-02-17 22:50:58Z mkwayisi $
 * ----------------------------------------------------------------------------
 * Authored by Michael Kwayisi. Copyright (c) 2009-2013. All rights reserved.
 * Please send your comments to mkwayisi@gmail.com | Web: michaelkwayisi.com
 * ----------------------------------------------------------------------------
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * stringently met:
 *   1. Redistributions of source code must retain the above copyright notice,
 *      this list of conditions, and the following disclaimer.
 *   2. Redistributions in binary form must reproduce the above copyright
 *      notice, this list of conditions, and the following disclaimer in the
 *      documentation and/or other materials provided with the package.
 *   3. The end-user documentation included with the redistribution, if any,
 *      must include the following acknowledgment:
 *         "This product includes software developed by Michael Kwayisi"
 *      Alternately, this acknowledgment may appear in the software itself,
 *      if and wherever such third-party acknowledgments normally appear.
 *   4. Neither the name of the software nor the name of its author and/or
 *      contributors may be used to endorse or promote products derived from
 *      this software without specific prior written permission.
 ******************************************************************************
 */

import java.util.ArrayList;
import java.math.BigDecimal;

public class Expression
{
//=============================================================================
// [DATA] Brackets, roots, exponents and factorial.
public static final byte BRO = 0x00, BRACKET_OPEN = BRO;
public static final byte BRC = 0x01, BRACKET_CLOSE = BRC;
public static final byte SRT = 0x02, SQUARE_ROOT = SRT;
public static final byte CRT = 0x03, CUBE_ROOT = CRT;
public static final byte REC = 0x04, RECIPROCAL = REC;
public static final byte SQR = 0x05, SQUARED = SQR;
public static final byte CUB = 0x06, CUBED = CUB;
public static final byte POW = 0x07, POWER = POW;
public static final byte FCT = 0x08, FACTORIAL = FCT;

//=============================================================================
// [DATA] Common mathematical functions.
public static final byte SIN = 0x10, SINE = SIN;
public static final byte COS = 0x11, COSINE = COS;
public static final byte TAN = 0x12, TANGENT = TAN;
public static final byte LOG = 0x13, LOGARITHM = LOG;
public static final byte NLG = 0x14, NATURAL_LOG = NLG;
public static final byte INT = 0x15, INTEGRAL = INT;
public static final byte NEG = 0x16, NEGATE = NEG;

//=============================================================================
// [DATA] The ubiquitous binary operators.
public static final byte MUL = 0x20, MULTIPLY = MUL;
public static final byte DIV = 0x21, DIVIDE = DIV;
public static final byte MOD = 0x22, MODULO = MOD;
public static final byte ADD = 0x23, ADDITION = ADD;
public static final byte SUB = 0x24, SUBTRACTION = SUB;

//=============================================================================
// [DATA] Class instance data fields.
private ArrayList list = null;
private Expression parent = null;

//=============================================================================
// [FUNC] Primary class constructor.
public Expression()
{
	this(null);
}

//=============================================================================
// [FUNC] Private constructor that makes objects with parents.
private Expression(Expression parent)
{
	this.list = new ArrayList();
	this.parent = parent;
}

//=============================================================================
// [FUNC] Returns a boolean value indicating whether this expression is
// embedded within another expression.
private boolean hasParent()
{
	return this.parent != null;
}

//=============================================================================
// [FUNC] Returns the parent expression of this expression.
private Expression getParent()
{
	return this.parent;
}

//=============================================================================
// [FUNC] Returns a boolean value indicating whether the passed parameter is
// an operator.
private static boolean isOperator(Object obj)
{
	byte opr = obj instanceof Byte ? (byte) obj : -1;
	return (opr >= BRO && opr <= FCT) || (opr >= SIN && opr <= NEG) ||
		(opr >= MUL && opr <= SUB);
}

//=============================================================================
// [FUNC] Returns a boolean value indicating whether the passed parameter is
// an operand (just BigDecimal for now).
private static boolean isOperand(Object obj)
{
	return obj instanceof BigDecimal;
}

//=============================================================================
// [FUNC] Returns a boolean value indicating wheher the passed parameter is
// an expression.
private static boolean isExpression(Object obj)
{
	return obj instanceof Expression;
}

//=============================================================================
// [FUNC] Computes and returns the factorial of the argument.
private static BigDecimal factorial(BigDecimal n)
{
	BigDecimal r = BigDecimal.ONE;
	while (n.compareTo(BigDecimal.ONE) > 0) {
		r = r.multiply(n);
		n = n.subtract(BigDecimal.ONE);
	}
	return r;
	//return n.compareTo(BigDecimal.ONE) > 0 ?
	//	factorial(n.subtract(BigDecimal.ONE)).multiply(n) : n;
}

//=============================================================================
// [FUNC] Returns a boolean value indicating whether there are items on stack.
public boolean hasItems()
{
	return list.size() > 0;
}

//=============================================================================
// [FUNC] Adds a new item onto the internal list. Think of it like stack?!
public Expression push(Object ... args)
{
	for (Object obj : args)
		this.list.add(obj);
	return this;
}

//=============================================================================
// [FUNC] Removes the last item (if any) from the internal stack.
public Object pop()
{
	int index = list.size() - 1;
	return (index >= 0) ? list.remove(index) : null;
}

//=============================================================================
// [FUNC] Evaluates and returns the result of this expression.
public BigDecimal eval()
	throws SyntaxErrorException, InvalidInputException, UnknownOperatorException
{
	Object obj = null;
	Expression curr = this;
	BigDecimal lhs = null, rhs = null;
	
	// STEP 0: Evaluate brackets to determine sub-expressions
	for (int i = 0; i < list.size(); i++) {
		obj = list.get(i);
		if (obj.equals(BRO)) {
			if (this.equals(curr)) {
				curr = new Expression(curr);
				list.set(i, curr);
				continue;
			} else {
				curr = new Expression(curr);
				curr.getParent().push(curr);
			}
		} else if (obj.equals(BRC)) {
			curr = curr.getParent();
			if (curr == null) break;
		} else if (this.equals(curr)) {
			if (!(isOperator(obj) || isExpression(obj)))
				list.set(i, new BigDecimal(obj.toString()));
			continue;
		} else curr.push(obj);
		list.remove(i--);
	}
	
	if (!this.equals(curr))
		throw new SyntaxErrorException("Unmatched brackets");
	
	// STEP 1: Translate SQR & CUB into POWs
	for (int i = 0; i < list.size(); i++) {
		obj = list.get(i);
		if (obj.equals(SQR) || obj.equals(CUB)) {
			list.set(i, new BigDecimal(obj.equals(SQR) ? 2 : 3));
			list.add(i, POW);
			i++;
		}
	}

	// STEP 2: Roots, powers, reciprocal and factorial.
	for (int i = 0; i < list.size(); i++) {
		obj = list.get(i);
		if (isOperator(obj)) switch ((byte) obj) {
			case SQUARE_ROOT:
			case CUBE_ROOT:
				obj = i + 1 < list.size() ? list.get(i + 1) : -1;
				if (obj.equals(SRT) || obj.equals(CRT)) continue;
				else if (isOperand(obj)) rhs = (BigDecimal) obj;
				else if (isExpression(obj)) rhs = ((Expression) obj).eval();
				else throw new SyntaxErrorException("Missing operand");
				if (rhs.compareTo(BigDecimal.ZERO) < 0)
					throw new ArithmeticException("Root of negative no.");
				rhs = new BigDecimal(list.get(i).equals(SRT) ?
					Math.sqrt(rhs.doubleValue()) : Math.cbrt(rhs.doubleValue()));
				list.set(i, rhs);
				list.remove(i + 1);
				i = Math.max(i - 2, -1);
				break;
				
			case POWER:
				obj = i + 2 < list.size() ? list.get(i + 2) : -1;
				if (obj.equals(POW)) continue;
				obj = i > 0 ? list.get(i - 1) : -1;
				if (isOperand(obj)) lhs = (BigDecimal) obj;
				else if (isExpression(obj)) lhs = ((Expression) obj).eval();
				else throw new SyntaxErrorException("Missing operand");
				obj = i + 1 < list.size() ? list.get(i + 1) : -1;
				if (isOperand(obj)) rhs = (BigDecimal) obj;
				else if (isExpression(obj)) rhs = ((Expression) obj).eval();
				else throw new SyntaxErrorException("Missing operand");
				if (rhs.compareTo(BigDecimal.ZERO) < 0)
					lhs = BigDecimal.ONE.divide(lhs.pow(rhs.abs().intValue()));
				else lhs = lhs.pow(rhs.intValue());
				list.set(i - 1, lhs);
				list.remove(i);
				list.remove(i);
				i = Math.max(i - 3, -1);
				break;
			
			case RECIPROCAL:
				obj = i > 0 ? list.get(i - 1) : -1;
				if (isOperand(obj)) lhs = (BigDecimal) obj;
				else if (isExpression(obj)) lhs = ((Expression) obj).eval();
				else throw new SyntaxErrorException("Missing operand");
				list.set(i - 1, BigDecimal.ONE.divide(lhs, 30, BigDecimal.ROUND_DOWN));
				list.remove(i);
				i -= 1;
				break;
				
			case FACTORIAL:
				obj = i > 0 ? list.get(i - 1) : -1;
				if (isOperand(obj)) lhs = (BigDecimal) obj;
				else if (isExpression(obj)) lhs = ((Expression) obj).eval();
				else throw new SyntaxErrorException("Missing operand");
				//if (lhs.compareTo(BigDecimal.ZERO) < 0)
				//	throw new InvalidInputException("Factorial input less than zero");
				//else if (lhs.compareTo(new BigDecimal(5000)) > 0)
				//	throw new InvalidInputException("Factorial input too large (>5000)");
				list.set(i - 1, factorial(lhs.setScale(0, BigDecimal.ROUND_DOWN)));
				list.remove(i);
				i -= 1;
				break;
		}
	}
	
	// STEP 3: Common mathematical functions.
	for (int i = list.size() - 1; i >= 0; i--) {
		obj = list.get(i);
		if (obj.equals(SIN) || obj.equals(COS) || obj.equals(TAN) ||
			obj.equals(LOG) || obj.equals(NLG) || obj.equals(INT) ||
			obj.equals(NEG))
		{
			obj = i + 1 < list.size() ? list.get(i + 1) : -1;
			if (isOperand(obj)) rhs = (BigDecimal) obj;
			else if (isExpression(obj)) rhs = ((Expression) obj).eval();
			else throw new SyntaxErrorException("Missing operand");
			switch ((byte) list.get(i)) {
				case SIN: rhs = new BigDecimal(Math.sin(Math.toRadians(rhs.doubleValue()))); break;
				case COS: rhs = new BigDecimal(Math.cos(Math.toRadians(rhs.doubleValue()))); break;
				case TAN:
					if (rhs.compareTo(new BigDecimal(90)) == 0)
						throw new ArithmeticException("Tangent 90");
					rhs = new BigDecimal(Math.tan(Math.toRadians(rhs.doubleValue())));
					break;
				case LOG: rhs = new BigDecimal(Math.log10(rhs.doubleValue())); break;
				case NLG: rhs = new BigDecimal(Math.log(rhs.doubleValue())); break;
				case INT: rhs = rhs.setScale(0, BigDecimal.ROUND_DOWN); break;
				case NEG: rhs = rhs.negate(); break;
				default: continue;
			}
			if (rhs.scale() > 15) rhs = rhs.setScale(15, BigDecimal.ROUND_HALF_EVEN);
			list.set(i, rhs);
			list.remove(i + 1);
		}
	}
	
	// STEP 4: Multiplicative and additive operations.
	for (int s = 0; s < 2; s++)
	for (int i = 0; i < list.size(); i++) {
		obj = list.get(i);
		if (s == 0 && (obj.equals(MUL) || obj.equals(DIV) || obj.equals(MOD)) ||
			s == 1 && (obj.equals(ADD) || obj.equals(SUB)))
		{
			obj = i > 0 ? list.get(i - 1) : -1;
			if (isOperand(obj)) lhs = (BigDecimal) obj;
			else if (isExpression(obj)) lhs = ((Expression) obj).eval();
			else throw new SyntaxErrorException("Missing operand");
			obj = i + 1 < list.size() ? list.get(i + 1) : -1;
			if (isOperand(obj)) rhs = (BigDecimal) obj;
			else if (isExpression(obj)) rhs = ((Expression) obj).eval();
			else throw new SyntaxErrorException("Missing operand");
			switch ((byte) list.get(i)) {
				case MUL: lhs = lhs.multiply(rhs); break;
				case DIV:
					if (rhs.compareTo(BigDecimal.ZERO) == 0)
						throw new ArithmeticException("Division by zero");
					lhs = lhs.divide(rhs, 30, BigDecimal.ROUND_DOWN);
					break;
				case MOD: lhs = lhs.remainder(rhs); break;
				case ADD: lhs = lhs.add(rhs); break;
				case SUB: lhs = lhs.subtract(rhs); break;
			}
			list.set(i - 1, lhs);
			list.remove(i);
			list.remove(i);
			i -= 1;
		} else if (isExpression(obj)) {
			list.set(i, rhs = ((Expression) obj).eval());
			obj = i > 0 ? list.get(i - 1) : -1;
			if (isOperand(obj)) {
				list.set(i - 1, rhs = rhs.multiply((BigDecimal) obj));
				list.remove(i);
				i -= 1;
			}
			obj = i + 1 < list.size() ? list.get(i + 1) : -1;
			if (isOperand(obj)) {
				list.set(i, rhs.multiply((BigDecimal) obj));
				list.remove(i + 1);
			}	
		}
	}

	// STEP 4: Multiply any remaining items. A cheap way to get my math right.
	// E.g. 2 sin 30 == 2 * sin 30
	while (list.size() > 1) {
		obj = list.get(0);
		if (isExpression(obj))
			lhs = ((Expression) obj).eval();
		else if (isOperand(obj))
			lhs = (BigDecimal) obj;
		else throw new UnknownOperatorException();
		obj = list.get(1);
		if (isExpression(obj))
			rhs = ((Expression) obj).eval();
		else if (isOperand(obj))
			rhs = (BigDecimal) obj;
		else throw new UnknownOperatorException();
		
		list.set(0, lhs.multiply(rhs));
		list.remove(1);
	}
	
	if (list.size() == 0)
		throw new SyntaxErrorException("Empty " + (this.hasParent() ? "brackets" : "expression"));
	else if (isExpression(list.get(0)))
		list.set(0, ((Expression) list.get(0)).eval());
	
	lhs = (BigDecimal) list.get(0);
	if (lhs.scale() > 30) lhs = lhs.setScale(30, BigDecimal.ROUND_HALF_EVEN);
	return lhs.stripTrailingZeros();
}

//=============================================================================
// [FUNC] Returns the string representation of this expression.
public String toString()
{
	String ret = "";
	Object obj = null;
	
	for (int i = 0; i < list.size(); i++) {
		obj = list.get(i);
		if (obj.equals(BRO)) ret += "(";
		else if (obj.equals(BRC)) ret += ")";
		else if (isExpression(obj)) ret += "[" + obj + "]";
		
		else if (obj.equals(SRT)) ret += "\u221A";
		else if (obj.equals(CRT)) ret += "\u221B";
		else if (obj.equals(REC)) ret += "\u02C9\u00B9";
		else if (obj.equals(SQR)) ret += "\u00B2";
		else if (obj.equals(CUB)) ret += "\u00B3";
		else if (obj.equals(POW)) ret += " ^ ";
		else if (obj.equals(FCT)) ret += "!";
		
		else if (obj.equals(SIN)) ret += " sin";
		else if (obj.equals(COS)) ret += " cos";
		else if (obj.equals(TAN)) ret += " tan";
		else if (obj.equals(LOG)) ret += " log";
		else if (obj.equals(NLG)) ret += " ln";
		else if (obj.equals(INT)) ret += "\u222B";
		else if (obj.equals(NEG)) ret += "-";
		
		else if (obj.equals(MUL)) ret += " \u00D7 ";
		else if (obj.equals(DIV)) ret += " \u00F7 ";
		else if (obj.equals(MOD)) ret += " mod ";
		else if (obj.equals(ADD)) ret += " \u002B ";
		else if (obj.equals(SUB)) ret += " - ";
		else if (i > 0 && (list.get(i - 1).equals(SRT) ||
			list.get(i - 1).equals(CRT) || list.get(i - 1).equals(NEG)))
				ret += obj;
		else ret += " " + obj;
	}
	
	ret = ret.replaceAll("\\s\\s+", " ");
	ret = ret.replaceAll("\\(\\s+", "(");
	return ret.trim();
}
}

