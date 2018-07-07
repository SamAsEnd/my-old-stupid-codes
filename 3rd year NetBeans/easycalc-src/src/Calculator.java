/**
 ******************************************************************************
 * $Id: Calculator.java 23 2013-02-17 22:50:58Z mkwayisi $
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

import java.math.BigDecimal;
import java.util.ArrayList;

public class Calculator
{
//=============================================================================
// [DATA] Static class data fields.
public static final String SCI = "Scientific";	// Scientific Mode
public static final String STD = "Standard";	// Standard Mode
public static final String GRP = "Digit Grouping"; // Digit Grouping

public static final String HEX = "Hex";			// Hexadecimal
public static final String DEC = "Dec";			// Decimal
public static final String OCT = "Oct";			// Octal
public static final String BIN = "Bin";			// Binary

public static final String MCX = "MC";			// Memory Clear
public static final String MRX = "MR";			// Memory Recall
public static final String MSX = "MS";			// Memory Store
public static final String MPX = "M+";			// Memory Add
public static final String MMX = "M-";			// Memory Subtract

public static final String XXX = null;			// Reserved
public static final String NLG = "ln";			// Natural Logarithm
public static final String BR1 = "(";			// Bracket Open
public static final String BR2 = ")";			// Bracket Close
public static final String BSP = "\u2190";		// Backspace
public static final String CEX = "CE";			// Clear Entry
public static final String CXX = " C ";			// Clear

public static final String SIN = "sin";			// Sine
public static final String COS = "cos";			// Cosine
public static final String TAN = "tan";			// Tangent
public static final String NEG = "\u00b1";		// Negate
public static final String REC = "1/x";			// Reciprocal
public static final String INT = "int";			// Integral
public static final String LOG = "log";			// Logarithm
public static final String PWT = "10\u02E3";	// X Power of Ten
public static final String F2E = "F-E";			// Fine to Exponential
public static final String EXP = "Exp";			// Exponential

public static final String SRT = "\u221a";		// Square Root
public static final String CRT = "\u221bx";		// Cube Root
public static final String SQR = "x\u00b2";		// Squared
public static final String CUB = "x\u00b3";		// Cubed
public static final String FCT = "n!";			// Factorial
public static final String PER = "%";			// Percentage
public static final String DMS = "dms";			// DMS
public static final String POW = "x\u02B8";		// Power

public static final String DG0 = "0";			// Digit 0
public static final String DG1 = "1";			// Digit 1
public static final String DG2 = "2";			// Digit 2
public static final String DG3 = "3";			// Digit 3
public static final String DG4 = "4";			// Digit 4
public static final String DG5 = "5";			// Digit 5
public static final String DG6 = "6";			// Digit 6
public static final String DG7 = "7";			// Digit 7
public static final String DG8 = "8";			// Digit 8
public static final String DG9 = "9";			// Digit 9
public static final String DOT = ".";			// Dot/Point

public static final String DGA = "A";			// Hex digit A
public static final String DGB = "B";			// Hex digit B
public static final String DGC = "C";			// Hex digit C
public static final String DGD = "D";			// Hex digit D
public static final String DGE = "E";			// Hex digit E
public static final String DGF = "F";			// Hex digit F

public static final String MUL = "\u00D7";		// Multiply
public static final String DIV = "\u00F7";		// Divide
public static final String MOD = "mod";			// Modulus
public static final String ADD = "\u002B";		// Add
public static final String SUB = "\u2212";		// Subtract
public static final String EQU = "\u003D";		// Equal to

public static final String PIX = "\u03C0";		// Constant PI
public static final String AVG = "\u03BC";		// Statistical Average
public static final String SUM = "\u2211";		// Statistical Sum
public static final String LST = "lst";			// Statistical Add
public static final String CLS = "clr";			// Clear stat list

//=============================================================================
// [DATA] Class instance data fields.
private Expression[] expr = null;
private String memValue = null;
private String prmScreenText = null;
private boolean clearPrmScreen = false;
private boolean groupDigits = false;
private boolean hasError = false;
private String numMode = null;
private String lastKey = null;
private ArrayList nset = null;

//=============================================================================
// [FUNC] Primary class constructor.
public Calculator()
{
	expr = new Expression[2];
	nset = new ArrayList();
	for (int i = 0; i < expr.length; i++)
		expr[i] = new Expression();
	numMode = DEC;
	memValue = "0";
	initFields();
}

//=============================================================================
// [FUNC] Re-initializes various fields.
private void initFields()
{
	clear();
	prmScreenText = "0";
	clearPrmScreen = true;
	hasError = false;
	lastKey = null;
}

//=============================================================================
// [FUNC] Returns a boolean value indicating whether the parameter is a digit.
private boolean isDigit(String val)
{
	return val == DG0 || val == DG1 || val == DG2 || val == DG3 || val == DG4 ||
		val == DG5 || val == DG6 || val == DG7 || val == DG8 || val == DG9 ||
			val == DGA || val == DGB || val == DGC || val == DGD || val == DGE || val == DGF;
}

//=============================================================================
// [FUNC] Returns a boolean value indicating whether this calculator has
// a stored memory value.
public boolean hasMemValue()
{
	return memValue != "0";
}

//=============================================================================
// [FUNC] Returns the number of items in the number set.
public int getSetSize()
{
	return nset.size();
}

//=============================================================================
// [FUNC] Returns the text for the secondary screen.
public String getSecScreenText()
{
	return expr[1] + (lastKey == EQU ? " =" : "");
}

//=============================================================================
// [FUNC] Returns the text for the primary screen.
public String getPrmScreenText()
{
	if (!hasError) {
		if (groupDigits) {
			if (numMode == BIN || numMode == HEX)
				return groupText(prmScreenText, 4, " ");
			else if (numMode == OCT)
				return groupText(prmScreenText, 3, " ");
			else return groupText(prmScreenText, 3, ",");
		}
	}
	return prmScreenText;
}

//=============================================================================
// [FUNC] Converts BigDecimal to a radix (No shit!)
private static String dec2rad(String str, BigDecimal rad)
{
	BigDecimal bd = new BigDecimal(str);
	String ret = "";
	int rem = 0;
	bd = bd.setScale(0, BigDecimal.ROUND_DOWN);
	while (bd.compareTo(BigDecimal.ZERO) > 0) {
		rem = bd.remainder(rad).intValue();
		if (rem >= 0 && rem <= 9)
			ret = (char) (rem + '0') + ret;
		else if (rem >= 10)
			ret = (char) (rem + 'A' - 10) + ret;
		bd = bd.divide(rad, 0, BigDecimal.ROUND_DOWN);
	}
	return ret == "" ? "0" : ret;
}

//=============================================================================
// [FUNC] Converts a radical value to BigDecimal.
private static String rad2dec(String str, BigDecimal rad)
{
	BigDecimal bd = new BigDecimal(0);
	int chr = 0;
	
	for (int i = str.length() - 1, p = 0; i >= 0; i--, p++) {
		chr = Character.toUpperCase(str.charAt(i));
		if (chr >= '0' && chr <= '9')
			bd = bd.add(rad.pow(p).multiply(new BigDecimal(chr - '0')));
		else if (chr >= 'A' && chr <= 'Z')
			bd = bd.add(rad.pow(p).multiply(new BigDecimal(chr - 'A' + 10)));
		else p--;	// Ignore other characters as if they weren't there ;)
	}
	
	return bd.toPlainString();
}

//=============================================================================
// [FUNC] Convert a decimal value to radical value.
private static String dec2rad(String str, String mode)
{
	if (mode == BIN)
		return dec2rad(str, new BigDecimal(2));
	else if (mode == OCT)
		return dec2rad(str, new BigDecimal(8));
	else if (mode == HEX)
		return dec2rad(str, new BigDecimal(16));
	return str;
}

//=============================================================================
// [FUNC] Convert a radical value to decimal.
private static String rad2dec(String str, String mode)
{
	if (mode == BIN)
		return rad2dec(str, new BigDecimal(2));
	else if (mode == OCT)
		return rad2dec(str, new BigDecimal(8));
	else if (mode == HEX)
		return rad2dec(str, new BigDecimal(16));
	return str;
}

//=============================================================================
// [FUNC] Returns a grouped text.
private static String groupText(String str, int cnt, String sep)
{
	String ret = "";
	int i = 0, a = 0, z = str.lastIndexOf(".");
	if (z <= 0) z = str.length();
	else ret = str.substring(z);
	if (str.length() > 0 && str.charAt(0) == '-') a++;
	
	for (i = z - cnt; i > a; i -= cnt)
		ret = sep + str.substring(i, i + cnt) + ret;
	
	return str.substring(0, i + cnt) + ret;
}

//=============================================================================
// [FUNC] Beep!
private static void beep()
{
	java.awt.Toolkit.getDefaultToolkit().beep();
}

//=============================================================================
// [FUNC] Clears all items from the expression stacks.
private void clear()
{
	for (int i = 0; i < expr.length; i++)
		while (expr[i].hasItems())
			expr[i].pop();
}

//=============================================================================
// [FUNC] Pushed a new item onto the expression stack.
private void push(Object obj)
{
	expr[1].push(obj);
	if (obj instanceof String) {
		expr[0].push(rad2dec((String) obj, numMode));
	} else expr[0].push(obj);
}

//=============================================================================
// [FUNC] Pops an item off the expression stack.
private void pop()
{
	expr[0].pop();
	expr[1].pop();
}

//=============================================================================
// [FUNC] Strips trailing zeros from a decimal string.
private String stripZeros(String s)
{
	if (s.indexOf(".") >= 0)
	while (s.length() > 1 && (s.endsWith("0") || s.endsWith(".")))
		s = s.substring(0, s.length() - 1);
	return s;
}

//=============================================================================
// [FUNC] Throws an error message to the user.
private void throwError(String msg)
{
	prmScreenText = msg;
	hasError = true;
	beep();
}

//=============================================================================
// [FUNC] Accepts input key from the user.
public void inputKey(String key)
{
	if (hasError) {
		if (key == CXX || key == GRP) {}
		else if (key == HEX || key == DEC || key == OCT || key == BIN)
			initFields();
		else { beep(); return; }
	} else if (lastKey == EQU && key != BSP) {
		clear();
	}
	
	switch (key) {
		case GRP:
			groupDigits = !groupDigits;
			if (hasError) return;
			break;
		case BIN:
		case OCT:
		case DEC:
		case HEX:
			prmScreenText = dec2rad(rad2dec(prmScreenText, numMode), key);
			numMode = key;
			clearPrmScreen = true;
			break;
		case MCX:
			memValue = "0";
			clearPrmScreen = true;
			break;
		case MRX:
			if (memValue != "0")
				prmScreenText = dec2rad(memValue, numMode);
			else { prmScreenText = "0"; lastKey = DG0; return; }
			clearPrmScreen = true;
			break;
		case MSX:
			memValue = rad2dec(prmScreenText, numMode);
			clearPrmScreen = true;
			break;
		case MPX:
			memValue = new BigDecimal(rad2dec(prmScreenText, numMode)).add(
				new BigDecimal(memValue)).toPlainString();
			clearPrmScreen = true;
			break;
		case MMX:
			memValue = new BigDecimal(rad2dec(memValue, numMode)).subtract(
				new BigDecimal(prmScreenText)).toPlainString();
			clearPrmScreen = true;
			break;
		case BSP:
			if (clearPrmScreen) {
				beep(); return;
			} else if (prmScreenText.length() > 1)
				prmScreenText = prmScreenText.substring(0, prmScreenText.length() - 1);
			else if (prmScreenText != "0")
				prmScreenText = "0";
			else if (expr[0].hasItems())
				pop();
			else beep();
			break;
		case CEX:
			prmScreenText = "0";
			break;
		case CXX:
			this.initFields();
			break;
		case AVG:
			if (nset.size() > 0) {
				BigDecimal bd = BigDecimal.ZERO;
				for (int i = 0; i < nset.size(); i++)
					bd = bd.add((BigDecimal) nset.get(i));
				prmScreenText = dec2rad(bd.divide(new BigDecimal(nset.size()), 32,
					BigDecimal.ROUND_HALF_EVEN).stripTrailingZeros().toPlainString(), numMode);
			} else throwError("Invalid Operation: Empty set");
			clearPrmScreen = true;
			break;
		case SUM:
			BigDecimal bd = BigDecimal.ZERO;
			for (int i = 0; i < nset.size(); i++)
				bd = bd.add((BigDecimal) nset.get(i));
			prmScreenText = dec2rad(bd.toPlainString(), numMode);
			clearPrmScreen = true;
			if (prmScreenText == "0") { lastKey = DG0; return; }
			break;
		case LST:
			if (prmScreenText != "0")
				nset.add(new BigDecimal(rad2dec(prmScreenText, numMode)));
			else beep();
			clearPrmScreen = true;
			break;
		case CLS:
			nset.clear();
			break;
		case DG0:
			if (clearPrmScreen) {
				prmScreenText = "0";
				clearPrmScreen = false;
			} else if (prmScreenText != "0")
				prmScreenText += key;
			else if (lastKey == DG0)
				beep();
			break;
		case DG1: case DG2: case DG3: case DG4: case DG5: case DG6: case DG7:
		case DG8: case DG9: case DGA: case DGB: case DGC: case DGD: case DGE:
		case DGF:
			if (clearPrmScreen || prmScreenText == DG0) {
				prmScreenText = key;
				clearPrmScreen = false;
			} else prmScreenText += key;
			break;
		case DOT:
			if (clearPrmScreen || prmScreenText == DG0) {
				prmScreenText = DG0 + DOT;
				clearPrmScreen = false;
			} else if (prmScreenText.indexOf(DOT) < 0)
				prmScreenText += key;
			else beep();
			break;
		case BR1: case BR2: case SRT: case CRT: case REC: case SQR: case CUB:
		case FCT: case SIN: case COS: case TAN: case LOG: case NLG: case INT:
		case NEG: case POW: case MUL: case DIV: case MOD: case ADD: case SUB:
			if (prmScreenText != "0" || isDigit(lastKey))
				push(prmScreenText);
			if (key.equals(BR1)) push(Expression.BRO);
			else if (key.equals(BR2)) push(Expression.BRC);
			else if (key.equals(SRT)) push(Expression.SRT);
			else if (key.equals(CRT)) push(Expression.CRT);
			else if (key.equals(REC)) push(Expression.REC);
			else if (key.equals(SQR)) push(Expression.SQR);
			else if (key.equals(CUB)) push(Expression.CUB);
			else if (key.equals(FCT)) push(Expression.FCT);
			else if (key.equals(SIN)) push(Expression.SIN);
			else if (key.equals(COS)) push(Expression.COS);
			else if (key.equals(TAN)) push(Expression.TAN);
			else if (key.equals(LOG)) push(Expression.LOG);
			else if (key.equals(NLG)) push(Expression.NLG);
			else if (key.equals(INT)) push(Expression.INT);
			else if (key.equals(NEG)) push(Expression.NEG);
			else if (key.equals(POW)) push(Expression.POW);
			else if (key.equals(MUL)) push(Expression.MUL);
			else if (key.equals(DIV)) push(Expression.DIV);
			else if (key.equals(MOD)) push(Expression.MOD);
			else if (key.equals(ADD)) push(Expression.ADD);
			else if (key.equals(SUB)) push(Expression.SUB);
			prmScreenText = "0";
			clearPrmScreen = false;
			break;
		case EQU:
			if (prmScreenText != "0" || isDigit(lastKey) || !expr[0].hasItems())
				push(prmScreenText);
			try {
				prmScreenText = stripZeros(expr[0].eval().toPlainString());
				if (numMode == BIN) prmScreenText = dec2rad(prmScreenText, BIN);
				else if (numMode == OCT) prmScreenText = dec2rad(prmScreenText, OCT);
				else if (numMode == HEX) prmScreenText = dec2rad(prmScreenText, HEX);
				clearPrmScreen = true;
			} catch (SyntaxErrorException e) {
				throwError("Syntax Error: " + e.getMessage());
			} catch (InvalidInputException e) {
				throwError("Input Error: " + e.getMessage());
			} catch (UnknownOperatorException e) {
				throwError("Unknown Operator: " + e.getMessage());
			} catch (ArithmeticException e) {
				throwError("Math Error: " + e.getMessage());
			} catch (Exception e) {
				throwError("Application Error: " + e.getMessage());
			}
			break;
	}
	
	lastKey = key;
}
}
