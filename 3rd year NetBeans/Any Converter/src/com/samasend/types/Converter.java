package com.samasend.types;

import com.samasend.types.Angle.Degree;
import com.samasend.types.Angle.Gradian;
import com.samasend.types.Angle.Radian;
import com.samasend.types.Area.Acres;
import com.samasend.types.Area.Hectares;
import com.samasend.types.Area.SquareCentimeter;
import com.samasend.types.Area.SquareFeet;
import com.samasend.types.Area.SquareInch;
import com.samasend.types.Area.SquareKilometer;
import com.samasend.types.Area.SquareMeter;
import com.samasend.types.Area.SquareMile;
import com.samasend.types.Area.SquareMillimeter;
import com.samasend.types.Area.SquareYard;
import com.samasend.types.Energy.BritishThermalUnit;
import com.samasend.types.Energy.Calorie;
import com.samasend.types.Energy.ElectronVolts;
import com.samasend.types.Energy.FootPound;
import com.samasend.types.Energy.Joule;
import com.samasend.types.Energy.Kilocalorie;
import com.samasend.types.Energy.Kilojoule;
import com.samasend.types.Length.Angstrom;
import com.samasend.types.Length.Centimeter;
import com.samasend.types.Length.Chain;
import com.samasend.types.Length.Fathom;
import com.samasend.types.Length.Feet;
import com.samasend.types.Length.Hand;
import com.samasend.types.Length.Inch;
import com.samasend.types.Length.Kilometer;
import com.samasend.types.Length.Link;
import com.samasend.types.Length.Meter;
import com.samasend.types.Length.Micron;
import com.samasend.types.Length.Mile;
import com.samasend.types.Length.MilliMeter;
import com.samasend.types.Length.NanoMeter;
import com.samasend.types.Length.NauticalMiles;
import com.samasend.types.Length.PICA;
import com.samasend.types.Length.Rods;
import com.samasend.types.Length.Span;
import com.samasend.types.Length.Yard;
import com.samasend.types.Power.BTUminute;
import com.samasend.types.Power.FootPoundminute;
import com.samasend.types.Power.Horsepower;
import com.samasend.types.Power.Kilowatt;
import com.samasend.types.Power.Watt;
import com.samasend.types.Pressure.Atmosphere;
import com.samasend.types.Pressure.Bar;
import com.samasend.types.Pressure.KiloPascal;
import com.samasend.types.Pressure.Millimeterofmercury;
import com.samasend.types.Pressure.Pascal;
import com.samasend.types.Pressure.PoundperSquareInchPSI;
import com.samasend.types.Temperature.DegreesCelsius;
import com.samasend.types.Temperature.DegreesFahrenheit;
import com.samasend.types.Temperature.Kelvin;
import com.samasend.types.Time.Day;
import com.samasend.types.Time.Hour;
import com.samasend.types.Time.Microsecond;
import com.samasend.types.Time.Millisecond;
import com.samasend.types.Time.Minute;
import com.samasend.types.Time.Month;
import com.samasend.types.Time.Second;
import com.samasend.types.Time.Week;
import com.samasend.types.Time.Year;
import com.samasend.types.Velocity.Centimeterpersecond;
import com.samasend.types.Velocity.Feetpersecond;
import com.samasend.types.Velocity.Kilometerpersecond;
import com.samasend.types.Velocity.Knots;
import com.samasend.types.Velocity.Meterpersecond;
import com.samasend.types.Velocity.Milepersecond;
import com.samasend.types.Volume.CubicCentimeter;
import com.samasend.types.Volume.CubicFeet;
import com.samasend.types.Volume.CubicInch;
import com.samasend.types.Volume.CubicMeter;
import com.samasend.types.Volume.CubicYard;
import com.samasend.types.Volume.FluidOunceUK;
import com.samasend.types.Volume.FluidOunceUS;
import com.samasend.types.Volume.GallonUK;
import com.samasend.types.Volume.GallonUS;
import com.samasend.types.Volume.Liter;
import com.samasend.types.Volume.PintUK;
import com.samasend.types.Volume.PintUS;
import com.samasend.types.Volume.QuartUK;
import com.samasend.types.Volume.QuartUS;

/**
 *
 * @author SamAsEnd
 */
public class Converter {

    private double value;
    private String type;
    private String from;
    private String to;
    private double result;

    public Converter(double value, String type, String from, String to) throws Exception {
        this.value = value;
        this.type = type;
        this.from = from;
        this.to = to;
        init();
    }

    private void init() throws Exception {
        switch (type) {
            case "Angle":
                switch (from) {
                    case "Degree":
                        Degree degree = new Degree(value);
                        switch (to) {
                            case "Degree":
                                result = degree.toDegree();
                                break;
                            case "Gradian":
                                result = degree.toGradian();
                                break;
                            case "Radian":
                                result = degree.toRadian();
                                break;
                        }
                        break;
                    case "Gradian":
                        Gradian gradian = new Gradian(value);
                        switch (to) {
                            case "Degree":
                                result = gradian.toDegree();
                                break;
                            case "Gradian":
                                result = gradian.toGradian();
                                break;
                            case "Radian":
                                result = gradian.toRadian();
                                break;
                        }
                        break;
                    case "Radian":
                        Radian radian = new Radian(value);
                        switch (to) {
                            case "Degree":
                                result = radian.toDegree();
                                break;
                            case "Gradian":
                                result = radian.toGradian();
                                break;
                            case "Radian":
                                result = radian.toRadian();
                                break;
                        }
                        break;
                }
                break;
            case "Time":
                switch (from) {
                    case "Day":
                        Day day = new Day(value);
                        switch (to) {
                            case "Day":
                                result = day.toDay();
                                break;
                            case "Hour":
                                result = day.toHour();
                                break;
                            case "Microsecond":
                                result = day.toMicrosecond();
                                break;
                            case "Millisecond":
                                result = day.toMillisecond();
                                break;
                            case "Minute":
                                result = day.toMinute();
                                break;
                            case "Month":
                                result = day.toMonth();
                                break;
                            case "Second":
                                result = day.toSecond();
                                break;
                            case "Week":
                                result = day.toWeek();
                                break;
                            case "Year":
                                result = day.toYear();
                                break;
                        }
                        break;
                    case "Hour":
                        Hour hour = new Hour(value);
                        switch (to) {
                            case "Day":
                                result = hour.toDay();
                                break;
                            case "Hour":
                                result = hour.toHour();
                                break;
                            case "Microsecond":
                                result = hour.toMicrosecond();
                                break;
                            case "Millisecond":
                                result = hour.toMillisecond();
                                break;
                            case "Minute":
                                result = hour.toMinute();
                                break;
                            case "Month":
                                result = hour.toMonth();
                                break;
                            case "Second":
                                result = hour.toSecond();
                                break;
                            case "Week":
                                result = hour.toWeek();
                                break;
                            case "Year":
                                result = hour.toYear();
                                break;
                        }
                        break;
                    case "Microsecond":
                        Microsecond microsecond = new Microsecond(value);
                        switch (to) {
                            case "Day":
                                result = microsecond.toDay();
                                break;
                            case "Hour":
                                result = microsecond.toHour();
                                break;
                            case "Microsecond":
                                result = microsecond.toMicrosecond();
                                break;
                            case "Millisecond":
                                result = microsecond.toMillisecond();
                                break;
                            case "Minute":
                                result = microsecond.toMinute();
                                break;
                            case "Month":
                                result = microsecond.toMonth();
                                break;
                            case "Second":
                                result = microsecond.toSecond();
                                break;
                            case "Week":
                                result = microsecond.toWeek();
                                break;
                            case "Year":
                                result = microsecond.toYear();
                                break;
                        }
                        break;
                    case "Millisecond":
                        Millisecond millisecond = new Millisecond(value);
                        switch (to) {
                            case "Day":
                                result = millisecond.toDay();
                                break;
                            case "Hour":
                                result = millisecond.toHour();
                                break;
                            case "Microsecond":
                                result = millisecond.toMicrosecond();
                                break;
                            case "Millisecond":
                                result = millisecond.toMillisecond();
                                break;
                            case "Minute":
                                result = millisecond.toMinute();
                                break;
                            case "Month":
                                result = millisecond.toMonth();
                                break;
                            case "Second":
                                result = millisecond.toSecond();
                                break;
                            case "Week":
                                result = millisecond.toWeek();
                                break;
                            case "Year":
                                result = millisecond.toYear();
                                break;
                        }
                        break;
                    case "Minute":
                        Minute minute = new Minute(value);
                        switch (to) {
                            case "Day":
                                result = minute.toDay();
                                break;
                            case "Hour":
                                result = minute.toHour();
                                break;
                            case "Microsecond":
                                result = minute.toMicrosecond();
                                break;
                            case "Millisecond":
                                result = minute.toMillisecond();
                                break;
                            case "Minute":
                                result = minute.toMinute();
                                break;
                            case "Month":
                                result = minute.toMonth();
                                break;
                            case "Second":
                                result = minute.toSecond();
                                break;
                            case "Week":
                                result = minute.toWeek();
                                break;
                            case "Year":
                                result = minute.toYear();
                                break;
                        }
                        break;
                    case "Month":
                        Month month = new Month(value);
                        switch (to) {
                            case "Day":
                                result = month.toDay();
                                break;
                            case "Hour":
                                result = month.toHour();
                                break;
                            case "Microsecond":
                                result = month.toMicrosecond();
                                break;
                            case "Millisecond":
                                result = month.toMillisecond();
                                break;
                            case "Minute":
                                result = month.toMinute();
                                break;
                            case "Month":
                                result = month.toMonth();
                                break;
                            case "Second":
                                result = month.toSecond();
                                break;
                            case "Week":
                                result = month.toWeek();
                                break;
                            case "Year":
                                result = month.toYear();
                                break;
                        }
                        break;
                    case "Second":
                        Second second = new Second(value);
                        switch (to) {
                            case "Day":
                                result = second.toDay();
                                break;
                            case "Hour":
                                result = second.toHour();
                                break;
                            case "Microsecond":
                                result = second.toMicrosecond();
                                break;
                            case "Millisecond":
                                result = second.toMillisecond();
                                break;
                            case "Minute":
                                result = second.toMinute();
                                break;
                            case "Month":
                                result = second.toMonth();
                                break;
                            case "Second":
                                result = second.toSecond();
                                break;
                            case "Week":
                                result = second.toWeek();
                                break;
                            case "Year":
                                result = second.toYear();
                                break;
                        }
                        break;
                    case "Week":
                        Week week = new Week(value);
                        switch (to) {
                            case "Day":
                                result = week.toDay();
                                break;
                            case "Hour":
                                result = week.toHour();
                                break;
                            case "Microsecond":
                                result = week.toMicrosecond();
                                break;
                            case "Millisecond":
                                result = week.toMillisecond();
                                break;
                            case "Minute":
                                result = week.toMinute();
                                break;
                            case "Month":
                                result = week.toMonth();
                                break;
                            case "Second":
                                result = week.toSecond();
                                break;
                            case "Week":
                                result = week.toWeek();
                                break;
                            case "Year":
                                result = week.toYear();
                                break;
                        }
                        break;
                    case "Year":
                        Year year = new Year(value);
                        switch (to) {
                            case "Day":
                                result = year.toDay();
                                break;
                            case "Hour":
                                result = year.toHour();
                                break;
                            case "Microsecond":
                                result = year.toMicrosecond();
                                break;
                            case "Millisecond":
                                result = year.toMillisecond();
                                break;
                            case "Minute":
                                result = year.toMinute();
                                break;
                            case "Month":
                                result = year.toMonth();
                                break;
                            case "Second":
                                result = year.toSecond();
                                break;
                            case "Week":
                                result = year.toWeek();
                                break;
                            case "Year":
                                result = year.toYear();
                                break;
                        }
                        break;
                }
                break;
            case "Volume":
                switch (from) {
                    case "CubicCentimeter":
                        CubicCentimeter cubicCentimeter = new CubicCentimeter(value);
                        switch (to) {
                            case "CubicCentimeter":
                                result = cubicCentimeter.toCubicCentimeter();
                                break;
                            case "CubicFeet":
                                result = cubicCentimeter.toCubicFeet();
                                break;
                            case "CubicInch":
                                result = cubicCentimeter.toCubicInch();
                                break;
                            case "CubicMeter":
                                result = cubicCentimeter.toCubicMeter();
                                break;
                            case "CubicYard":
                                result = cubicCentimeter.toCubicYard();
                                break;
                            case "FluidOunceUK":
                                result = cubicCentimeter.toFluidOunceUK();
                                break;
                            case "FluidOunceUS":
                                result = cubicCentimeter.toFluidOunceUS();
                                break;
                            case "GallonUK":
                                result = cubicCentimeter.toGallonUK();
                                break;
                            case "GallonUS":
                                result = cubicCentimeter.toGallonUS();
                                break;
                            case "Liter":
                                result = cubicCentimeter.toLiter();
                                break;
                            case "PintUK":
                                result = cubicCentimeter.toPintUK();
                                break;
                            case "PintUS":
                                result = cubicCentimeter.toPintUS();
                                break;
                            case "QuartUK":
                                result = cubicCentimeter.toQuartUK();
                                break;
                            case "QuartUS":
                                result = cubicCentimeter.toQuartUS();
                                break;
                        }
                        break;
                    case "CubicFeet":
                        CubicFeet cubicFeet = new CubicFeet(value);
                        switch (to) {
                            case "CubicCentimeter":
                                result = cubicFeet.toCubicCentimeter();
                                break;
                            case "CubicFeet":
                                result = cubicFeet.toCubicFeet();
                                break;
                            case "CubicInch":
                                result = cubicFeet.toCubicInch();
                                break;
                            case "CubicMeter":
                                result = cubicFeet.toCubicMeter();
                                break;
                            case "CubicYard":
                                result = cubicFeet.toCubicYard();
                                break;
                            case "FluidOunceUK":
                                result = cubicFeet.toFluidOunceUK();
                                break;
                            case "FluidOunceUS":
                                result = cubicFeet.toFluidOunceUS();
                                break;
                            case "GallonUK":
                                result = cubicFeet.toGallonUK();
                                break;
                            case "GallonUS":
                                result = cubicFeet.toGallonUS();
                                break;
                            case "Liter":
                                result = cubicFeet.toLiter();
                                break;
                            case "PintUK":
                                result = cubicFeet.toPintUK();
                                break;
                            case "PintUS":
                                result = cubicFeet.toPintUS();
                                break;
                            case "QuartUK":
                                result = cubicFeet.toQuartUK();
                                break;
                            case "QuartUS":
                                result = cubicFeet.toQuartUS();
                                break;
                        }
                        break;
                    case "CubicInch":
                        CubicInch cubicInch = new CubicInch(value);
                        switch (to) {
                            case "CubicCentimeter":
                                result = cubicInch.toCubicCentimeter();
                                break;
                            case "CubicFeet":
                                result = cubicInch.toCubicFeet();
                                break;
                            case "CubicInch":
                                result = cubicInch.toCubicInch();
                                break;
                            case "CubicMeter":
                                result = cubicInch.toCubicMeter();
                                break;
                            case "CubicYard":
                                result = cubicInch.toCubicYard();
                                break;
                            case "FluidOunceUK":
                                result = cubicInch.toFluidOunceUK();
                                break;
                            case "FluidOunceUS":
                                result = cubicInch.toFluidOunceUS();
                                break;
                            case "GallonUK":
                                result = cubicInch.toGallonUK();
                                break;
                            case "GallonUS":
                                result = cubicInch.toGallonUS();
                                break;
                            case "Liter":
                                result = cubicInch.toLiter();
                                break;
                            case "PintUK":
                                result = cubicInch.toPintUK();
                                break;
                            case "PintUS":
                                result = cubicInch.toPintUS();
                                break;
                            case "QuartUK":
                                result = cubicInch.toQuartUK();
                                break;
                            case "QuartUS":
                                result = cubicInch.toQuartUS();
                                break;
                        }
                        break;
                    case "CubicMeter":
                        CubicMeter cubicMeter = new CubicMeter(value);
                        switch (to) {
                            case "CubicCentimeter":
                                result = cubicMeter.toCubicCentimeter();
                                break;
                            case "CubicFeet":
                                result = cubicMeter.toCubicFeet();
                                break;
                            case "CubicInch":
                                result = cubicMeter.toCubicInch();
                                break;
                            case "CubicMeter":
                                result = cubicMeter.toCubicMeter();
                                break;
                            case "CubicYard":
                                result = cubicMeter.toCubicYard();
                                break;
                            case "FluidOunceUK":
                                result = cubicMeter.toFluidOunceUK();
                                break;
                            case "FluidOunceUS":
                                result = cubicMeter.toFluidOunceUS();
                                break;
                            case "GallonUK":
                                result = cubicMeter.toGallonUK();
                                break;
                            case "GallonUS":
                                result = cubicMeter.toGallonUS();
                                break;
                            case "Liter":
                                result = cubicMeter.toLiter();
                                break;
                            case "PintUK":
                                result = cubicMeter.toPintUK();
                                break;
                            case "PintUS":
                                result = cubicMeter.toPintUS();
                                break;
                            case "QuartUK":
                                result = cubicMeter.toQuartUK();
                                break;
                            case "QuartUS":
                                result = cubicMeter.toQuartUS();
                                break;
                        }
                        break;
                    case "CubicYard":
                        CubicYard cubicYard = new CubicYard(value);
                        switch (to) {
                            case "CubicCentimeter":
                                result = cubicYard.toCubicCentimeter();
                                break;
                            case "CubicFeet":
                                result = cubicYard.toCubicFeet();
                                break;
                            case "CubicInch":
                                result = cubicYard.toCubicInch();
                                break;
                            case "CubicMeter":
                                result = cubicYard.toCubicMeter();
                                break;
                            case "CubicYard":
                                result = cubicYard.toCubicYard();
                                break;
                            case "FluidOunceUK":
                                result = cubicYard.toFluidOunceUK();
                                break;
                            case "FluidOunceUS":
                                result = cubicYard.toFluidOunceUS();
                                break;
                            case "GallonUK":
                                result = cubicYard.toGallonUK();
                                break;
                            case "GallonUS":
                                result = cubicYard.toGallonUS();
                                break;
                            case "Liter":
                                result = cubicYard.toLiter();
                                break;
                            case "PintUK":
                                result = cubicYard.toPintUK();
                                break;
                            case "PintUS":
                                result = cubicYard.toPintUS();
                                break;
                            case "QuartUK":
                                result = cubicYard.toQuartUK();
                                break;
                            case "QuartUS":
                                result = cubicYard.toQuartUS();
                                break;
                        }
                        break;
                    case "FluidOunceUK":
                        FluidOunceUK fluidOunceUK = new FluidOunceUK(value);
                        switch (to) {
                            case "CubicCentimeter":
                                result = fluidOunceUK.toCubicCentimeter();
                                break;
                            case "CubicFeet":
                                result = fluidOunceUK.toCubicFeet();
                                break;
                            case "CubicInch":
                                result = fluidOunceUK.toCubicInch();
                                break;
                            case "CubicMeter":
                                result = fluidOunceUK.toCubicMeter();
                                break;
                            case "CubicYard":
                                result = fluidOunceUK.toCubicYard();
                                break;
                            case "FluidOunceUK":
                                result = fluidOunceUK.toFluidOunceUK();
                                break;
                            case "FluidOunceUS":
                                result = fluidOunceUK.toFluidOunceUS();
                                break;
                            case "GallonUK":
                                result = fluidOunceUK.toGallonUK();
                                break;
                            case "GallonUS":
                                result = fluidOunceUK.toGallonUS();
                                break;
                            case "Liter":
                                result = fluidOunceUK.toLiter();
                                break;
                            case "PintUK":
                                result = fluidOunceUK.toPintUK();
                                break;
                            case "PintUS":
                                result = fluidOunceUK.toPintUS();
                                break;
                            case "QuartUK":
                                result = fluidOunceUK.toQuartUK();
                                break;
                            case "QuartUS":
                                result = fluidOunceUK.toQuartUS();
                                break;
                        }
                        break;
                    case "FluidOunceUS":
                        FluidOunceUS fluidOunceUS = new FluidOunceUS(value);
                        switch (to) {
                            case "CubicCentimeter":
                                result = fluidOunceUS.toCubicCentimeter();
                                break;
                            case "CubicFeet":
                                result = fluidOunceUS.toCubicFeet();
                                break;
                            case "CubicInch":
                                result = fluidOunceUS.toCubicInch();
                                break;
                            case "CubicMeter":
                                result = fluidOunceUS.toCubicMeter();
                                break;
                            case "CubicYard":
                                result = fluidOunceUS.toCubicYard();
                                break;
                            case "FluidOunceUK":
                                result = fluidOunceUS.toFluidOunceUK();
                                break;
                            case "FluidOunceUS":
                                result = fluidOunceUS.toFluidOunceUS();
                                break;
                            case "GallonUK":
                                result = fluidOunceUS.toGallonUK();
                                break;
                            case "GallonUS":
                                result = fluidOunceUS.toGallonUS();
                                break;
                            case "Liter":
                                result = fluidOunceUS.toLiter();
                                break;
                            case "PintUK":
                                result = fluidOunceUS.toPintUK();
                                break;
                            case "PintUS":
                                result = fluidOunceUS.toPintUS();
                                break;
                            case "QuartUK":
                                result = fluidOunceUS.toQuartUK();
                                break;
                            case "QuartUS":
                                result = fluidOunceUS.toQuartUS();
                                break;
                        }
                        break;
                    case "GallonUK":
                        GallonUK gallonUK = new GallonUK(value);
                        switch (to) {
                            case "CubicCentimeter":
                                result = gallonUK.toCubicCentimeter();
                                break;
                            case "CubicFeet":
                                result = gallonUK.toCubicFeet();
                                break;
                            case "CubicInch":
                                result = gallonUK.toCubicInch();
                                break;
                            case "CubicMeter":
                                result = gallonUK.toCubicMeter();
                                break;
                            case "CubicYard":
                                result = gallonUK.toCubicYard();
                                break;
                            case "FluidOunceUK":
                                result = gallonUK.toFluidOunceUK();
                                break;
                            case "FluidOunceUS":
                                result = gallonUK.toFluidOunceUS();
                                break;
                            case "GallonUK":
                                result = gallonUK.toGallonUK();
                                break;
                            case "GallonUS":
                                result = gallonUK.toGallonUS();
                                break;
                            case "Liter":
                                result = gallonUK.toLiter();
                                break;
                            case "PintUK":
                                result = gallonUK.toPintUK();
                                break;
                            case "PintUS":
                                result = gallonUK.toPintUS();
                                break;
                            case "QuartUK":
                                result = gallonUK.toQuartUK();
                                break;
                            case "QuartUS":
                                result = gallonUK.toQuartUS();
                                break;
                        }
                        break;
                    case "GallonUS":
                        GallonUS gallonUS = new GallonUS(value);
                        switch (to) {
                            case "CubicCentimeter":
                                result = gallonUS.toCubicCentimeter();
                                break;
                            case "CubicFeet":
                                result = gallonUS.toCubicFeet();
                                break;
                            case "CubicInch":
                                result = gallonUS.toCubicInch();
                                break;
                            case "CubicMeter":
                                result = gallonUS.toCubicMeter();
                                break;
                            case "CubicYard":
                                result = gallonUS.toCubicYard();
                                break;
                            case "FluidOunceUK":
                                result = gallonUS.toFluidOunceUK();
                                break;
                            case "FluidOunceUS":
                                result = gallonUS.toFluidOunceUS();
                                break;
                            case "GallonUK":
                                result = gallonUS.toGallonUK();
                                break;
                            case "GallonUS":
                                result = gallonUS.toGallonUS();
                                break;
                            case "Liter":
                                result = gallonUS.toLiter();
                                break;
                            case "PintUK":
                                result = gallonUS.toPintUK();
                                break;
                            case "PintUS":
                                result = gallonUS.toPintUS();
                                break;
                            case "QuartUK":
                                result = gallonUS.toQuartUK();
                                break;
                            case "QuartUS":
                                result = gallonUS.toQuartUS();
                                break;
                        }
                        break;
                    case "Liter":
                        Liter liter = new Liter(value);
                        switch (to) {
                            case "CubicCentimeter":
                                result = liter.toCubicCentimeter();
                                break;
                            case "CubicFeet":
                                result = liter.toCubicFeet();
                                break;
                            case "CubicInch":
                                result = liter.toCubicInch();
                                break;
                            case "CubicMeter":
                                result = liter.toCubicMeter();
                                break;
                            case "CubicYard":
                                result = liter.toCubicYard();
                                break;
                            case "FluidOunceUK":
                                result = liter.toFluidOunceUK();
                                break;
                            case "FluidOunceUS":
                                result = liter.toFluidOunceUS();
                                break;
                            case "GallonUK":
                                result = liter.toGallonUK();
                                break;
                            case "GallonUS":
                                result = liter.toGallonUS();
                                break;
                            case "Liter":
                                result = liter.toLiter();
                                break;
                            case "PintUK":
                                result = liter.toPintUK();
                                break;
                            case "PintUS":
                                result = liter.toPintUS();
                                break;
                            case "QuartUK":
                                result = liter.toQuartUK();
                                break;
                            case "QuartUS":
                                result = liter.toQuartUS();
                                break;
                        }
                        break;
                    case "PintUK":
                        PintUK pintUK = new PintUK(value);
                        switch (to) {
                            case "CubicCentimeter":
                                result = pintUK.toCubicCentimeter();
                                break;
                            case "CubicFeet":
                                result = pintUK.toCubicFeet();
                                break;
                            case "CubicInch":
                                result = pintUK.toCubicInch();
                                break;
                            case "CubicMeter":
                                result = pintUK.toCubicMeter();
                                break;
                            case "CubicYard":
                                result = pintUK.toCubicYard();
                                break;
                            case "FluidOunceUK":
                                result = pintUK.toFluidOunceUK();
                                break;
                            case "FluidOunceUS":
                                result = pintUK.toFluidOunceUS();
                                break;
                            case "GallonUK":
                                result = pintUK.toGallonUK();
                                break;
                            case "GallonUS":
                                result = pintUK.toGallonUS();
                                break;
                            case "Liter":
                                result = pintUK.toLiter();
                                break;
                            case "PintUK":
                                result = pintUK.toPintUK();
                                break;
                            case "PintUS":
                                result = pintUK.toPintUS();
                                break;
                            case "QuartUK":
                                result = pintUK.toQuartUK();
                                break;
                            case "QuartUS":
                                result = pintUK.toQuartUS();
                                break;
                        }
                        break;
                    case "PintUS":
                        PintUS pintUS = new PintUS(value);
                        switch (to) {
                            case "CubicCentimeter":
                                result = pintUS.toCubicCentimeter();
                                break;
                            case "CubicFeet":
                                result = pintUS.toCubicFeet();
                                break;
                            case "CubicInch":
                                result = pintUS.toCubicInch();
                                break;
                            case "CubicMeter":
                                result = pintUS.toCubicMeter();
                                break;
                            case "CubicYard":
                                result = pintUS.toCubicYard();
                                break;
                            case "FluidOunceUK":
                                result = pintUS.toFluidOunceUK();
                                break;
                            case "FluidOunceUS":
                                result = pintUS.toFluidOunceUS();
                                break;
                            case "GallonUK":
                                result = pintUS.toGallonUK();
                                break;
                            case "GallonUS":
                                result = pintUS.toGallonUS();
                                break;
                            case "Liter":
                                result = pintUS.toLiter();
                                break;
                            case "PintUK":
                                result = pintUS.toPintUK();
                                break;
                            case "PintUS":
                                result = pintUS.toPintUS();
                                break;
                            case "QuartUK":
                                result = pintUS.toQuartUK();
                                break;
                            case "QuartUS":
                                result = pintUS.toQuartUS();
                                break;
                        }
                        break;
                    case "QuartUK":
                        QuartUK quartUK = new QuartUK(value);
                        switch (to) {
                            case "CubicCentimeter":
                                result = quartUK.toCubicCentimeter();
                                break;
                            case "CubicFeet":
                                result = quartUK.toCubicFeet();
                                break;
                            case "CubicInch":
                                result = quartUK.toCubicInch();
                                break;
                            case "CubicMeter":
                                result = quartUK.toCubicMeter();
                                break;
                            case "CubicYard":
                                result = quartUK.toCubicYard();
                                break;
                            case "FluidOunceUK":
                                result = quartUK.toFluidOunceUK();
                                break;
                            case "FluidOunceUS":
                                result = quartUK.toFluidOunceUS();
                                break;
                            case "GallonUK":
                                result = quartUK.toGallonUK();
                                break;
                            case "GallonUS":
                                result = quartUK.toGallonUS();
                                break;
                            case "Liter":
                                result = quartUK.toLiter();
                                break;
                            case "PintUK":
                                result = quartUK.toPintUK();
                                break;
                            case "PintUS":
                                result = quartUK.toPintUS();
                                break;
                            case "QuartUK":
                                result = quartUK.toQuartUK();
                                break;
                            case "QuartUS":
                                result = quartUK.toQuartUS();
                                break;
                        }
                        break;
                    case "QuartUS":
                        QuartUS quartUS = new QuartUS(value);
                        switch (to) {
                            case "CubicCentimeter":
                                result = quartUS.toCubicCentimeter();
                                break;
                            case "CubicFeet":
                                result = quartUS.toCubicFeet();
                                break;
                            case "CubicInch":
                                result = quartUS.toCubicInch();
                                break;
                            case "CubicMeter":
                                result = quartUS.toCubicMeter();
                                break;
                            case "CubicYard":
                                result = quartUS.toCubicYard();
                                break;
                            case "FluidOunceUK":
                                result = quartUS.toFluidOunceUK();
                                break;
                            case "FluidOunceUS":
                                result = quartUS.toFluidOunceUS();
                                break;
                            case "GallonUK":
                                result = quartUS.toGallonUK();
                                break;
                            case "GallonUS":
                                result = quartUS.toGallonUS();
                                break;
                            case "Liter":
                                result = quartUS.toLiter();
                                break;
                            case "PintUK":
                                result = quartUS.toPintUK();
                                break;
                            case "PintUS":
                                result = quartUS.toPintUS();
                                break;
                            case "QuartUK":
                                result = quartUS.toQuartUK();
                                break;
                            case "QuartUS":
                                result = quartUS.toQuartUS();
                                break;
                        }
                        break;
                }
                break;
            case "Power":
                switch (from) {
                    case "BTUminute":
                        BTUminute bTUminute = new BTUminute(value);
                        switch (to) {
                            case "BTUminute":
                                result = bTUminute.toBTUminute();
                                break;
                            case "FootPoundminute":
                                result = bTUminute.toFootPoundminute();
                                break;
                            case "Horsepower":
                                result = bTUminute.toHorsepower();
                                break;
                            case "Kilowatt":
                                result = bTUminute.toKilowatt();
                                break;
                            case "Watt":
                                result = bTUminute.toWatt();
                                break;
                        }
                        break;
                    case "FootPoundminute":
                        FootPoundminute footPoundminute = new FootPoundminute(value);
                        switch (to) {
                            case "BTUminute":
                                result = footPoundminute.toBTUminute();
                                break;
                            case "FootPoundminute":
                                result = footPoundminute.toFootPoundminute();
                                break;
                            case "Horsepower":
                                result = footPoundminute.toHorsepower();
                                break;
                            case "Kilowatt":
                                result = footPoundminute.toKilowatt();
                                break;
                            case "Watt":
                                result = footPoundminute.toWatt();
                                break;
                        }
                        break;
                    case "Horsepower":
                        Horsepower horsepower = new Horsepower(value);
                        switch (to) {
                            case "BTUminute":
                                result = horsepower.toBTUminute();
                                break;
                            case "FootPoundminute":
                                result = horsepower.toFootPoundminute();
                                break;
                            case "Horsepower":
                                result = horsepower.toHorsepower();
                                break;
                            case "Kilowatt":
                                result = horsepower.toKilowatt();
                                break;
                            case "Watt":
                                result = horsepower.toWatt();
                                break;
                        }
                        break;
                    case "Kilowatt":
                        Kilowatt kilowatt = new Kilowatt(value);
                        switch (to) {
                            case "BTUminute":
                                result = kilowatt.toBTUminute();
                                break;
                            case "FootPoundminute":
                                result = kilowatt.toFootPoundminute();
                                break;
                            case "Horsepower":
                                result = kilowatt.toHorsepower();
                                break;
                            case "Kilowatt":
                                result = kilowatt.toKilowatt();
                                break;
                            case "Watt":
                                result = kilowatt.toWatt();
                                break;
                        }
                        break;
                    case "Watt":
                        Watt watt = new Watt(value);
                        switch (to) {
                            case "BTUminute":
                                result = watt.toBTUminute();
                                break;
                            case "FootPoundminute":
                                result = watt.toFootPoundminute();
                                break;
                            case "Horsepower":
                                result = watt.toHorsepower();
                                break;
                            case "Kilowatt":
                                result = watt.toKilowatt();
                                break;
                            case "Watt":
                                result = watt.toWatt();
                                break;
                        }
                        break;
                }
                break;
            case "Energy":
                switch (from) {
                    case "BritishThermalUnit":
                        BritishThermalUnit britishThermalUnit = new BritishThermalUnit(value);
                        switch (to) {
                            case "BritishThermalUnit":
                                result = britishThermalUnit.toBritishThermalUnit();
                                break;
                            case "Calorie":
                                result = britishThermalUnit.toCalorie();
                                break;
                            case "ElectronVolts":
                                result = britishThermalUnit.toElectronVolts();
                                break;
                            case "FootPound":
                                result = britishThermalUnit.toFootPound();
                                break;
                            case "Joule":
                                result = britishThermalUnit.toJoule();
                                break;
                            case "Kilocalorie":
                                result = britishThermalUnit.toKilocalorie();
                                break;
                            case "Kilojoule":
                                result = britishThermalUnit.toKilojoule();
                                break;
                        }
                        break;
                    case "Calorie":
                        Calorie calorie = new Calorie(value);
                        switch (to) {
                            case "BritishThermalUnit":
                                result = calorie.toBritishThermalUnit();
                                break;
                            case "Calorie":
                                result = calorie.toCalorie();
                                break;
                            case "ElectronVolts":
                                result = calorie.toElectronVolts();
                                break;
                            case "FootPound":
                                result = calorie.toFootPound();
                                break;
                            case "Joule":
                                result = calorie.toJoule();
                                break;
                            case "Kilocalorie":
                                result = calorie.toKilocalorie();
                                break;
                            case "Kilojoule":
                                result = calorie.toKilojoule();
                                break;
                        }
                        break;
                    case "ElectronVolts":
                        ElectronVolts electronVolts = new ElectronVolts(value);
                        switch (to) {
                            case "BritishThermalUnit":
                                result = electronVolts.toBritishThermalUnit();
                                break;
                            case "Calorie":
                                result = electronVolts.toCalorie();
                                break;
                            case "ElectronVolts":
                                result = electronVolts.toElectronVolts();
                                break;
                            case "FootPound":
                                result = electronVolts.toFootPound();
                                break;
                            case "Joule":
                                result = electronVolts.toJoule();
                                break;
                            case "Kilocalorie":
                                result = electronVolts.toKilocalorie();
                                break;
                            case "Kilojoule":
                                result = electronVolts.toKilojoule();
                                break;
                        }
                        break;
                    case "FootPound":
                        FootPound footPound = new FootPound(value);
                        switch (to) {
                            case "BritishThermalUnit":
                                result = footPound.toBritishThermalUnit();
                                break;
                            case "Calorie":
                                result = footPound.toCalorie();
                                break;
                            case "ElectronVolts":
                                result = footPound.toElectronVolts();
                                break;
                            case "FootPound":
                                result = footPound.toFootPound();
                                break;
                            case "Joule":
                                result = footPound.toJoule();
                                break;
                            case "Kilocalorie":
                                result = footPound.toKilocalorie();
                                break;
                            case "Kilojoule":
                                result = footPound.toKilojoule();
                                break;
                        }
                        break;
                    case "Joule":
                        Joule joule = new Joule(value);
                        switch (to) {
                            case "BritishThermalUnit":
                                result = joule.toBritishThermalUnit();
                                break;
                            case "Calorie":
                                result = joule.toCalorie();
                                break;
                            case "ElectronVolts":
                                result = joule.toElectronVolts();
                                break;
                            case "FootPound":
                                result = joule.toFootPound();
                                break;
                            case "Joule":
                                result = joule.toJoule();
                                break;
                            case "Kilocalorie":
                                result = joule.toKilocalorie();
                                break;
                            case "Kilojoule":
                                result = joule.toKilojoule();
                                break;
                        }
                        break;
                    case "Kilocalorie":
                        Kilocalorie kilocalorie = new Kilocalorie(value);
                        switch (to) {
                            case "BritishThermalUnit":
                                result = kilocalorie.toBritishThermalUnit();
                                break;
                            case "Calorie":
                                result = kilocalorie.toCalorie();
                                break;
                            case "ElectronVolts":
                                result = kilocalorie.toElectronVolts();
                                break;
                            case "FootPound":
                                result = kilocalorie.toFootPound();
                                break;
                            case "Joule":
                                result = kilocalorie.toJoule();
                                break;
                            case "Kilocalorie":
                                result = kilocalorie.toKilocalorie();
                                break;
                            case "Kilojoule":
                                result = kilocalorie.toKilojoule();
                                break;
                        }
                        break;
                    case "Kilojoule":
                        Kilojoule kilojoule = new Kilojoule(value);
                        switch (to) {
                            case "BritishThermalUnit":
                                result = kilojoule.toBritishThermalUnit();
                                break;
                            case "Calorie":
                                result = kilojoule.toCalorie();
                                break;
                            case "ElectronVolts":
                                result = kilojoule.toElectronVolts();
                                break;
                            case "FootPound":
                                result = kilojoule.toFootPound();
                                break;
                            case "Joule":
                                result = kilojoule.toJoule();
                                break;
                            case "Kilocalorie":
                                result = kilojoule.toKilocalorie();
                                break;
                            case "Kilojoule":
                                result = kilojoule.toKilojoule();
                                break;
                        }
                        break;
                }
                break;
            case "Length":
                switch (from) {
                    case "Angstrom":
                        Angstrom angstrom = new Angstrom(value);
                        switch (to) {
                            case "Angstrom":
                                result = angstrom.toAngstrom();
                                break;
                            case "Centimeter":
                                result = angstrom.toCentimeter();
                                break;
                            case "Chain":
                                result = angstrom.toChain();
                                break;
                            case "Fathom":
                                result = angstrom.toFathom();
                                break;
                            case "Feet":
                                result = angstrom.toFeet();
                                break;
                            case "Hand":
                                result = angstrom.toHand();
                                break;
                            case "Inch":
                                result = angstrom.toInch();
                                break;
                            case "Kilometer":
                                result = angstrom.toKilometer();
                                break;
                            case "Link":
                                result = angstrom.toLink();
                                break;
                            case "Meter":
                                result = angstrom.toMeter();
                                break;
                            case "Micron":
                                result = angstrom.toMicron();
                                break;
                            case "Mile":
                                result = angstrom.toMile();
                                break;
                            case "MilliMeter":
                                result = angstrom.toMilliMeter();
                                break;
                            case "NanoMeter":
                                result = angstrom.toNanoMeter();
                                break;
                            case "NauticalMiles":
                                result = angstrom.toNauticalMiles();
                                break;
                            case "PICA":
                                result = angstrom.toPICA();
                                break;
                            case "Rods":
                                result = angstrom.toRods();
                                break;
                            case "Span":
                                result = angstrom.toSpan();
                                break;
                            case "Yard":
                                result = angstrom.toYard();
                                break;
                        }
                        break;
                    case "Centimeter":
                        Centimeter centimeter = new Centimeter(value);
                        switch (to) {
                            case "Angstrom":
                                result = centimeter.toAngstrom();
                                break;
                            case "Centimeter":
                                result = centimeter.toCentimeter();
                                break;
                            case "Chain":
                                result = centimeter.toChain();
                                break;
                            case "Fathom":
                                result = centimeter.toFathom();
                                break;
                            case "Feet":
                                result = centimeter.toFeet();
                                break;
                            case "Hand":
                                result = centimeter.toHand();
                                break;
                            case "Inch":
                                result = centimeter.toInch();
                                break;
                            case "Kilometer":
                                result = centimeter.toKilometer();
                                break;
                            case "Link":
                                result = centimeter.toLink();
                                break;
                            case "Meter":
                                result = centimeter.toMeter();
                                break;
                            case "Micron":
                                result = centimeter.toMicron();
                                break;
                            case "Mile":
                                result = centimeter.toMile();
                                break;
                            case "MilliMeter":
                                result = centimeter.toMilliMeter();
                                break;
                            case "NanoMeter":
                                result = centimeter.toNanoMeter();
                                break;
                            case "NauticalMiles":
                                result = centimeter.toNauticalMiles();
                                break;
                            case "PICA":
                                result = centimeter.toPICA();
                                break;
                            case "Rods":
                                result = centimeter.toRods();
                                break;
                            case "Span":
                                result = centimeter.toSpan();
                                break;
                            case "Yard":
                                result = centimeter.toYard();
                                break;
                        }
                        break;
                    case "Chain":
                        Chain chain = new Chain(value);
                        switch (to) {
                            case "Angstrom":
                                result = chain.toAngstrom();
                                break;
                            case "Centimeter":
                                result = chain.toCentimeter();
                                break;
                            case "Chain":
                                result = chain.toChain();
                                break;
                            case "Fathom":
                                result = chain.toFathom();
                                break;
                            case "Feet":
                                result = chain.toFeet();
                                break;
                            case "Hand":
                                result = chain.toHand();
                                break;
                            case "Inch":
                                result = chain.toInch();
                                break;
                            case "Kilometer":
                                result = chain.toKilometer();
                                break;
                            case "Link":
                                result = chain.toLink();
                                break;
                            case "Meter":
                                result = chain.toMeter();
                                break;
                            case "Micron":
                                result = chain.toMicron();
                                break;
                            case "Mile":
                                result = chain.toMile();
                                break;
                            case "MilliMeter":
                                result = chain.toMilliMeter();
                                break;
                            case "NanoMeter":
                                result = chain.toNanoMeter();
                                break;
                            case "NauticalMiles":
                                result = chain.toNauticalMiles();
                                break;
                            case "PICA":
                                result = chain.toPICA();
                                break;
                            case "Rods":
                                result = chain.toRods();
                                break;
                            case "Span":
                                result = chain.toSpan();
                                break;
                            case "Yard":
                                result = chain.toYard();
                                break;
                        }
                        break;
                    case "Fathom":
                        Fathom fathom = new Fathom(value);
                        switch (to) {
                            case "Angstrom":
                                result = fathom.toAngstrom();
                                break;
                            case "Centimeter":
                                result = fathom.toCentimeter();
                                break;
                            case "Chain":
                                result = fathom.toChain();
                                break;
                            case "Fathom":
                                result = fathom.toFathom();
                                break;
                            case "Feet":
                                result = fathom.toFeet();
                                break;
                            case "Hand":
                                result = fathom.toHand();
                                break;
                            case "Inch":
                                result = fathom.toInch();
                                break;
                            case "Kilometer":
                                result = fathom.toKilometer();
                                break;
                            case "Link":
                                result = fathom.toLink();
                                break;
                            case "Meter":
                                result = fathom.toMeter();
                                break;
                            case "Micron":
                                result = fathom.toMicron();
                                break;
                            case "Mile":
                                result = fathom.toMile();
                                break;
                            case "MilliMeter":
                                result = fathom.toMilliMeter();
                                break;
                            case "NanoMeter":
                                result = fathom.toNanoMeter();
                                break;
                            case "NauticalMiles":
                                result = fathom.toNauticalMiles();
                                break;
                            case "PICA":
                                result = fathom.toPICA();
                                break;
                            case "Rods":
                                result = fathom.toRods();
                                break;
                            case "Span":
                                result = fathom.toSpan();
                                break;
                            case "Yard":
                                result = fathom.toYard();
                                break;
                        }
                        break;
                    case "Feet":
                        Feet feet = new Feet(value);
                        switch (to) {
                            case "Angstrom":
                                result = feet.toAngstrom();
                                break;
                            case "Centimeter":
                                result = feet.toCentimeter();
                                break;
                            case "Chain":
                                result = feet.toChain();
                                break;
                            case "Fathom":
                                result = feet.toFathom();
                                break;
                            case "Feet":
                                result = feet.toFeet();
                                break;
                            case "Hand":
                                result = feet.toHand();
                                break;
                            case "Inch":
                                result = feet.toInch();
                                break;
                            case "Kilometer":
                                result = feet.toKilometer();
                                break;
                            case "Link":
                                result = feet.toLink();
                                break;
                            case "Meter":
                                result = feet.toMeter();
                                break;
                            case "Micron":
                                result = feet.toMicron();
                                break;
                            case "Mile":
                                result = feet.toMile();
                                break;
                            case "MilliMeter":
                                result = feet.toMilliMeter();
                                break;
                            case "NanoMeter":
                                result = feet.toNanoMeter();
                                break;
                            case "NauticalMiles":
                                result = feet.toNauticalMiles();
                                break;
                            case "PICA":
                                result = feet.toPICA();
                                break;
                            case "Rods":
                                result = feet.toRods();
                                break;
                            case "Span":
                                result = feet.toSpan();
                                break;
                            case "Yard":
                                result = feet.toYard();
                                break;
                        }
                        break;
                    case "Hand":
                        Hand hand = new Hand(value);
                        switch (to) {
                            case "Angstrom":
                                result = hand.toAngstrom();
                                break;
                            case "Centimeter":
                                result = hand.toCentimeter();
                                break;
                            case "Chain":
                                result = hand.toChain();
                                break;
                            case "Fathom":
                                result = hand.toFathom();
                                break;
                            case "Feet":
                                result = hand.toFeet();
                                break;
                            case "Hand":
                                result = hand.toHand();
                                break;
                            case "Inch":
                                result = hand.toInch();
                                break;
                            case "Kilometer":
                                result = hand.toKilometer();
                                break;
                            case "Link":
                                result = hand.toLink();
                                break;
                            case "Meter":
                                result = hand.toMeter();
                                break;
                            case "Micron":
                                result = hand.toMicron();
                                break;
                            case "Mile":
                                result = hand.toMile();
                                break;
                            case "MilliMeter":
                                result = hand.toMilliMeter();
                                break;
                            case "NanoMeter":
                                result = hand.toNanoMeter();
                                break;
                            case "NauticalMiles":
                                result = hand.toNauticalMiles();
                                break;
                            case "PICA":
                                result = hand.toPICA();
                                break;
                            case "Rods":
                                result = hand.toRods();
                                break;
                            case "Span":
                                result = hand.toSpan();
                                break;
                            case "Yard":
                                result = hand.toYard();
                                break;
                        }
                        break;
                    case "Inch":
                        Inch inch = new Inch(value);
                        switch (to) {
                            case "Angstrom":
                                result = inch.toAngstrom();
                                break;
                            case "Centimeter":
                                result = inch.toCentimeter();
                                break;
                            case "Chain":
                                result = inch.toChain();
                                break;
                            case "Fathom":
                                result = inch.toFathom();
                                break;
                            case "Feet":
                                result = inch.toFeet();
                                break;
                            case "Hand":
                                result = inch.toHand();
                                break;
                            case "Inch":
                                result = inch.toInch();
                                break;
                            case "Kilometer":
                                result = inch.toKilometer();
                                break;
                            case "Link":
                                result = inch.toLink();
                                break;
                            case "Meter":
                                result = inch.toMeter();
                                break;
                            case "Micron":
                                result = inch.toMicron();
                                break;
                            case "Mile":
                                result = inch.toMile();
                                break;
                            case "MilliMeter":
                                result = inch.toMilliMeter();
                                break;
                            case "NanoMeter":
                                result = inch.toNanoMeter();
                                break;
                            case "NauticalMiles":
                                result = inch.toNauticalMiles();
                                break;
                            case "PICA":
                                result = inch.toPICA();
                                break;
                            case "Rods":
                                result = inch.toRods();
                                break;
                            case "Span":
                                result = inch.toSpan();
                                break;
                            case "Yard":
                                result = inch.toYard();
                                break;
                        }
                        break;
                    case "Kilometer":
                        Kilometer kilometer = new Kilometer(value);
                        switch (to) {
                            case "Angstrom":
                                result = kilometer.toAngstrom();
                                break;
                            case "Centimeter":
                                result = kilometer.toCentimeter();
                                break;
                            case "Chain":
                                result = kilometer.toChain();
                                break;
                            case "Fathom":
                                result = kilometer.toFathom();
                                break;
                            case "Feet":
                                result = kilometer.toFeet();
                                break;
                            case "Hand":
                                result = kilometer.toHand();
                                break;
                            case "Inch":
                                result = kilometer.toInch();
                                break;
                            case "Kilometer":
                                result = kilometer.toKilometer();
                                break;
                            case "Link":
                                result = kilometer.toLink();
                                break;
                            case "Meter":
                                result = kilometer.toMeter();
                                break;
                            case "Micron":
                                result = kilometer.toMicron();
                                break;
                            case "Mile":
                                result = kilometer.toMile();
                                break;
                            case "MilliMeter":
                                result = kilometer.toMilliMeter();
                                break;
                            case "NanoMeter":
                                result = kilometer.toNanoMeter();
                                break;
                            case "NauticalMiles":
                                result = kilometer.toNauticalMiles();
                                break;
                            case "PICA":
                                result = kilometer.toPICA();
                                break;
                            case "Rods":
                                result = kilometer.toRods();
                                break;
                            case "Span":
                                result = kilometer.toSpan();
                                break;
                            case "Yard":
                                result = kilometer.toYard();
                                break;
                        }
                        break;
                    case "Link":
                        Link link = new Link(value);
                        switch (to) {
                            case "Angstrom":
                                result = link.toAngstrom();
                                break;
                            case "Centimeter":
                                result = link.toCentimeter();
                                break;
                            case "Chain":
                                result = link.toChain();
                                break;
                            case "Fathom":
                                result = link.toFathom();
                                break;
                            case "Feet":
                                result = link.toFeet();
                                break;
                            case "Hand":
                                result = link.toHand();
                                break;
                            case "Inch":
                                result = link.toInch();
                                break;
                            case "Kilometer":
                                result = link.toKilometer();
                                break;
                            case "Link":
                                result = link.toLink();
                                break;
                            case "Meter":
                                result = link.toMeter();
                                break;
                            case "Micron":
                                result = link.toMicron();
                                break;
                            case "Mile":
                                result = link.toMile();
                                break;
                            case "MilliMeter":
                                result = link.toMilliMeter();
                                break;
                            case "NanoMeter":
                                result = link.toNanoMeter();
                                break;
                            case "NauticalMiles":
                                result = link.toNauticalMiles();
                                break;
                            case "PICA":
                                result = link.toPICA();
                                break;
                            case "Rods":
                                result = link.toRods();
                                break;
                            case "Span":
                                result = link.toSpan();
                                break;
                            case "Yard":
                                result = link.toYard();
                                break;
                        }
                        break;
                    case "Meter":
                        Meter meter = new Meter(value);
                        switch (to) {
                            case "Angstrom":
                                result = meter.toAngstrom();
                                break;
                            case "Centimeter":
                                result = meter.toCentimeter();
                                break;
                            case "Chain":
                                result = meter.toChain();
                                break;
                            case "Fathom":
                                result = meter.toFathom();
                                break;
                            case "Feet":
                                result = meter.toFeet();
                                break;
                            case "Hand":
                                result = meter.toHand();
                                break;
                            case "Inch":
                                result = meter.toInch();
                                break;
                            case "Kilometer":
                                result = meter.toKilometer();
                                break;
                            case "Link":
                                result = meter.toLink();
                                break;
                            case "Meter":
                                result = meter.toMeter();
                                break;
                            case "Micron":
                                result = meter.toMicron();
                                break;
                            case "Mile":
                                result = meter.toMile();
                                break;
                            case "MilliMeter":
                                result = meter.toMilliMeter();
                                break;
                            case "NanoMeter":
                                result = meter.toNanoMeter();
                                break;
                            case "NauticalMiles":
                                result = meter.toNauticalMiles();
                                break;
                            case "PICA":
                                result = meter.toPICA();
                                break;
                            case "Rods":
                                result = meter.toRods();
                                break;
                            case "Span":
                                result = meter.toSpan();
                                break;
                            case "Yard":
                                result = meter.toYard();
                                break;
                        }
                        break;
                    case "Micron":
                        Micron micron = new Micron(value);
                        switch (to) {
                            case "Angstrom":
                                result = micron.toAngstrom();
                                break;
                            case "Centimeter":
                                result = micron.toCentimeter();
                                break;
                            case "Chain":
                                result = micron.toChain();
                                break;
                            case "Fathom":
                                result = micron.toFathom();
                                break;
                            case "Feet":
                                result = micron.toFeet();
                                break;
                            case "Hand":
                                result = micron.toHand();
                                break;
                            case "Inch":
                                result = micron.toInch();
                                break;
                            case "Kilometer":
                                result = micron.toKilometer();
                                break;
                            case "Link":
                                result = micron.toLink();
                                break;
                            case "Meter":
                                result = micron.toMeter();
                                break;
                            case "Micron":
                                result = micron.toMicron();
                                break;
                            case "Mile":
                                result = micron.toMile();
                                break;
                            case "MilliMeter":
                                result = micron.toMilliMeter();
                                break;
                            case "NanoMeter":
                                result = micron.toNanoMeter();
                                break;
                            case "NauticalMiles":
                                result = micron.toNauticalMiles();
                                break;
                            case "PICA":
                                result = micron.toPICA();
                                break;
                            case "Rods":
                                result = micron.toRods();
                                break;
                            case "Span":
                                result = micron.toSpan();
                                break;
                            case "Yard":
                                result = micron.toYard();
                                break;
                        }
                        break;
                    case "Mile":
                        Mile mile = new Mile(value);
                        switch (to) {
                            case "Angstrom":
                                result = mile.toAngstrom();
                                break;
                            case "Centimeter":
                                result = mile.toCentimeter();
                                break;
                            case "Chain":
                                result = mile.toChain();
                                break;
                            case "Fathom":
                                result = mile.toFathom();
                                break;
                            case "Feet":
                                result = mile.toFeet();
                                break;
                            case "Hand":
                                result = mile.toHand();
                                break;
                            case "Inch":
                                result = mile.toInch();
                                break;
                            case "Kilometer":
                                result = mile.toKilometer();
                                break;
                            case "Link":
                                result = mile.toLink();
                                break;
                            case "Meter":
                                result = mile.toMeter();
                                break;
                            case "Micron":
                                result = mile.toMicron();
                                break;
                            case "Mile":
                                result = mile.toMile();
                                break;
                            case "MilliMeter":
                                result = mile.toMilliMeter();
                                break;
                            case "NanoMeter":
                                result = mile.toNanoMeter();
                                break;
                            case "NauticalMiles":
                                result = mile.toNauticalMiles();
                                break;
                            case "PICA":
                                result = mile.toPICA();
                                break;
                            case "Rods":
                                result = mile.toRods();
                                break;
                            case "Span":
                                result = mile.toSpan();
                                break;
                            case "Yard":
                                result = mile.toYard();
                                break;
                        }
                        break;
                    case "MilliMeter":
                        MilliMeter milliMeter = new MilliMeter(value);
                        switch (to) {
                            case "Angstrom":
                                result = milliMeter.toAngstrom();
                                break;
                            case "Centimeter":
                                result = milliMeter.toCentimeter();
                                break;
                            case "Chain":
                                result = milliMeter.toChain();
                                break;
                            case "Fathom":
                                result = milliMeter.toFathom();
                                break;
                            case "Feet":
                                result = milliMeter.toFeet();
                                break;
                            case "Hand":
                                result = milliMeter.toHand();
                                break;
                            case "Inch":
                                result = milliMeter.toInch();
                                break;
                            case "Kilometer":
                                result = milliMeter.toKilometer();
                                break;
                            case "Link":
                                result = milliMeter.toLink();
                                break;
                            case "Meter":
                                result = milliMeter.toMeter();
                                break;
                            case "Micron":
                                result = milliMeter.toMicron();
                                break;
                            case "Mile":
                                result = milliMeter.toMile();
                                break;
                            case "MilliMeter":
                                result = milliMeter.toMilliMeter();
                                break;
                            case "NanoMeter":
                                result = milliMeter.toNanoMeter();
                                break;
                            case "NauticalMiles":
                                result = milliMeter.toNauticalMiles();
                                break;
                            case "PICA":
                                result = milliMeter.toPICA();
                                break;
                            case "Rods":
                                result = milliMeter.toRods();
                                break;
                            case "Span":
                                result = milliMeter.toSpan();
                                break;
                            case "Yard":
                                result = milliMeter.toYard();
                                break;
                        }
                        break;
                    case "NanoMeter":
                        NanoMeter nanoMeter = new NanoMeter(value);
                        switch (to) {
                            case "Angstrom":
                                result = nanoMeter.toAngstrom();
                                break;
                            case "Centimeter":
                                result = nanoMeter.toCentimeter();
                                break;
                            case "Chain":
                                result = nanoMeter.toChain();
                                break;
                            case "Fathom":
                                result = nanoMeter.toFathom();
                                break;
                            case "Feet":
                                result = nanoMeter.toFeet();
                                break;
                            case "Hand":
                                result = nanoMeter.toHand();
                                break;
                            case "Inch":
                                result = nanoMeter.toInch();
                                break;
                            case "Kilometer":
                                result = nanoMeter.toKilometer();
                                break;
                            case "Link":
                                result = nanoMeter.toLink();
                                break;
                            case "Meter":
                                result = nanoMeter.toMeter();
                                break;
                            case "Micron":
                                result = nanoMeter.toMicron();
                                break;
                            case "Mile":
                                result = nanoMeter.toMile();
                                break;
                            case "MilliMeter":
                                result = nanoMeter.toMilliMeter();
                                break;
                            case "NanoMeter":
                                result = nanoMeter.toNanoMeter();
                                break;
                            case "NauticalMiles":
                                result = nanoMeter.toNauticalMiles();
                                break;
                            case "PICA":
                                result = nanoMeter.toPICA();
                                break;
                            case "Rods":
                                result = nanoMeter.toRods();
                                break;
                            case "Span":
                                result = nanoMeter.toSpan();
                                break;
                            case "Yard":
                                result = nanoMeter.toYard();
                                break;
                        }
                        break;
                    case "NauticalMiles":
                        NauticalMiles nauticalMiles = new NauticalMiles(value);
                        switch (to) {
                            case "Angstrom":
                                result = nauticalMiles.toAngstrom();
                                break;
                            case "Centimeter":
                                result = nauticalMiles.toCentimeter();
                                break;
                            case "Chain":
                                result = nauticalMiles.toChain();
                                break;
                            case "Fathom":
                                result = nauticalMiles.toFathom();
                                break;
                            case "Feet":
                                result = nauticalMiles.toFeet();
                                break;
                            case "Hand":
                                result = nauticalMiles.toHand();
                                break;
                            case "Inch":
                                result = nauticalMiles.toInch();
                                break;
                            case "Kilometer":
                                result = nauticalMiles.toKilometer();
                                break;
                            case "Link":
                                result = nauticalMiles.toLink();
                                break;
                            case "Meter":
                                result = nauticalMiles.toMeter();
                                break;
                            case "Micron":
                                result = nauticalMiles.toMicron();
                                break;
                            case "Mile":
                                result = nauticalMiles.toMile();
                                break;
                            case "MilliMeter":
                                result = nauticalMiles.toMilliMeter();
                                break;
                            case "NanoMeter":
                                result = nauticalMiles.toNanoMeter();
                                break;
                            case "NauticalMiles":
                                result = nauticalMiles.toNauticalMiles();
                                break;
                            case "PICA":
                                result = nauticalMiles.toPICA();
                                break;
                            case "Rods":
                                result = nauticalMiles.toRods();
                                break;
                            case "Span":
                                result = nauticalMiles.toSpan();
                                break;
                            case "Yard":
                                result = nauticalMiles.toYard();
                                break;
                        }
                        break;
                    case "PICA":
                        PICA pICA = new PICA(value);
                        switch (to) {
                            case "Angstrom":
                                result = pICA.toAngstrom();
                                break;
                            case "Centimeter":
                                result = pICA.toCentimeter();
                                break;
                            case "Chain":
                                result = pICA.toChain();
                                break;
                            case "Fathom":
                                result = pICA.toFathom();
                                break;
                            case "Feet":
                                result = pICA.toFeet();
                                break;
                            case "Hand":
                                result = pICA.toHand();
                                break;
                            case "Inch":
                                result = pICA.toInch();
                                break;
                            case "Kilometer":
                                result = pICA.toKilometer();
                                break;
                            case "Link":
                                result = pICA.toLink();
                                break;
                            case "Meter":
                                result = pICA.toMeter();
                                break;
                            case "Micron":
                                result = pICA.toMicron();
                                break;
                            case "Mile":
                                result = pICA.toMile();
                                break;
                            case "MilliMeter":
                                result = pICA.toMilliMeter();
                                break;
                            case "NanoMeter":
                                result = pICA.toNanoMeter();
                                break;
                            case "NauticalMiles":
                                result = pICA.toNauticalMiles();
                                break;
                            case "PICA":
                                result = pICA.toPICA();
                                break;
                            case "Rods":
                                result = pICA.toRods();
                                break;
                            case "Span":
                                result = pICA.toSpan();
                                break;
                            case "Yard":
                                result = pICA.toYard();
                                break;
                        }
                        break;
                    case "Rods":
                        Rods rods = new Rods(value);
                        switch (to) {
                            case "Angstrom":
                                result = rods.toAngstrom();
                                break;
                            case "Centimeter":
                                result = rods.toCentimeter();
                                break;
                            case "Chain":
                                result = rods.toChain();
                                break;
                            case "Fathom":
                                result = rods.toFathom();
                                break;
                            case "Feet":
                                result = rods.toFeet();
                                break;
                            case "Hand":
                                result = rods.toHand();
                                break;
                            case "Inch":
                                result = rods.toInch();
                                break;
                            case "Kilometer":
                                result = rods.toKilometer();
                                break;
                            case "Link":
                                result = rods.toLink();
                                break;
                            case "Meter":
                                result = rods.toMeter();
                                break;
                            case "Micron":
                                result = rods.toMicron();
                                break;
                            case "Mile":
                                result = rods.toMile();
                                break;
                            case "MilliMeter":
                                result = rods.toMilliMeter();
                                break;
                            case "NanoMeter":
                                result = rods.toNanoMeter();
                                break;
                            case "NauticalMiles":
                                result = rods.toNauticalMiles();
                                break;
                            case "PICA":
                                result = rods.toPICA();
                                break;
                            case "Rods":
                                result = rods.toRods();
                                break;
                            case "Span":
                                result = rods.toSpan();
                                break;
                            case "Yard":
                                result = rods.toYard();
                                break;
                        }
                        break;
                    case "Span":
                        Span span = new Span(value);
                        switch (to) {
                            case "Angstrom":
                                result = span.toAngstrom();
                                break;
                            case "Centimeter":
                                result = span.toCentimeter();
                                break;
                            case "Chain":
                                result = span.toChain();
                                break;
                            case "Fathom":
                                result = span.toFathom();
                                break;
                            case "Feet":
                                result = span.toFeet();
                                break;
                            case "Hand":
                                result = span.toHand();
                                break;
                            case "Inch":
                                result = span.toInch();
                                break;
                            case "Kilometer":
                                result = span.toKilometer();
                                break;
                            case "Link":
                                result = span.toLink();
                                break;
                            case "Meter":
                                result = span.toMeter();
                                break;
                            case "Micron":
                                result = span.toMicron();
                                break;
                            case "Mile":
                                result = span.toMile();
                                break;
                            case "MilliMeter":
                                result = span.toMilliMeter();
                                break;
                            case "NanoMeter":
                                result = span.toNanoMeter();
                                break;
                            case "NauticalMiles":
                                result = span.toNauticalMiles();
                                break;
                            case "PICA":
                                result = span.toPICA();
                                break;
                            case "Rods":
                                result = span.toRods();
                                break;
                            case "Span":
                                result = span.toSpan();
                                break;
                            case "Yard":
                                result = span.toYard();
                                break;
                        }
                        break;
                    case "Yard":
                        Yard yard = new Yard(value);
                        switch (to) {
                            case "Angstrom":
                                result = yard.toAngstrom();
                                break;
                            case "Centimeter":
                                result = yard.toCentimeter();
                                break;
                            case "Chain":
                                result = yard.toChain();
                                break;
                            case "Fathom":
                                result = yard.toFathom();
                                break;
                            case "Feet":
                                result = yard.toFeet();
                                break;
                            case "Hand":
                                result = yard.toHand();
                                break;
                            case "Inch":
                                result = yard.toInch();
                                break;
                            case "Kilometer":
                                result = yard.toKilometer();
                                break;
                            case "Link":
                                result = yard.toLink();
                                break;
                            case "Meter":
                                result = yard.toMeter();
                                break;
                            case "Micron":
                                result = yard.toMicron();
                                break;
                            case "Mile":
                                result = yard.toMile();
                                break;
                            case "MilliMeter":
                                result = yard.toMilliMeter();
                                break;
                            case "NanoMeter":
                                result = yard.toNanoMeter();
                                break;
                            case "NauticalMiles":
                                result = yard.toNauticalMiles();
                                break;
                            case "PICA":
                                result = yard.toPICA();
                                break;
                            case "Rods":
                                result = yard.toRods();
                                break;
                            case "Span":
                                result = yard.toSpan();
                                break;
                            case "Yard":
                                result = yard.toYard();
                                break;
                        }
                        break;
                }
                break;
            case "Area":
                switch (from) {
                    case "Acres":
                        Acres acres = new Acres(value);
                        switch (to) {
                            case "Acres":
                                result = acres.toAcres();
                                break;
                            case "Hectares":
                                result = acres.toHectares();
                                break;
                            case "SquareCentimeter":
                                result = acres.toSquareCentimeter();
                                break;
                            case "SquareFeet":
                                result = acres.toSquareFeet();
                                break;
                            case "SquareInch":
                                result = acres.toSquareInch();
                                break;
                            case "SquareKilometer":
                                result = acres.toSquareKilometer();
                                break;
                            case "SquareMeter":
                                result = acres.toSquareMeter();
                                break;
                            case "SquareMile":
                                result = acres.toSquareMile();
                                break;
                            case "SquareMillimeter":
                                result = acres.toSquareMillimeter();
                                break;
                            case "SquareYard":
                                result = acres.toSquareYard();
                                break;
                        }
                        break;
                    case "Hectares":
                        Hectares hectares = new Hectares(value);
                        switch (to) {
                            case "Acres":
                                result = hectares.toAcres();
                                break;
                            case "Hectares":
                                result = hectares.toHectares();
                                break;
                            case "SquareCentimeter":
                                result = hectares.toSquareCentimeter();
                                break;
                            case "SquareFeet":
                                result = hectares.toSquareFeet();
                                break;
                            case "SquareInch":
                                result = hectares.toSquareInch();
                                break;
                            case "SquareKilometer":
                                result = hectares.toSquareKilometer();
                                break;
                            case "SquareMeter":
                                result = hectares.toSquareMeter();
                                break;
                            case "SquareMile":
                                result = hectares.toSquareMile();
                                break;
                            case "SquareMillimeter":
                                result = hectares.toSquareMillimeter();
                                break;
                            case "SquareYard":
                                result = hectares.toSquareYard();
                                break;
                        }
                        break;
                    case "SquareCentimeter":
                        SquareCentimeter squareCentimeter = new SquareCentimeter(value);
                        switch (to) {
                            case "Acres":
                                result = squareCentimeter.toAcres();
                                break;
                            case "Hectares":
                                result = squareCentimeter.toHectares();
                                break;
                            case "SquareCentimeter":
                                result = squareCentimeter.toSquareCentimeter();
                                break;
                            case "SquareFeet":
                                result = squareCentimeter.toSquareFeet();
                                break;
                            case "SquareInch":
                                result = squareCentimeter.toSquareInch();
                                break;
                            case "SquareKilometer":
                                result = squareCentimeter.toSquareKilometer();
                                break;
                            case "SquareMeter":
                                result = squareCentimeter.toSquareMeter();
                                break;
                            case "SquareMile":
                                result = squareCentimeter.toSquareMile();
                                break;
                            case "SquareMillimeter":
                                result = squareCentimeter.toSquareMillimeter();
                                break;
                            case "SquareYard":
                                result = squareCentimeter.toSquareYard();
                                break;
                        }
                        break;
                    case "SquareFeet":
                        SquareFeet squareFeet = new SquareFeet(value);
                        switch (to) {
                            case "Acres":
                                result = squareFeet.toAcres();
                                break;
                            case "Hectares":
                                result = squareFeet.toHectares();
                                break;
                            case "SquareCentimeter":
                                result = squareFeet.toSquareCentimeter();
                                break;
                            case "SquareFeet":
                                result = squareFeet.toSquareFeet();
                                break;
                            case "SquareInch":
                                result = squareFeet.toSquareInch();
                                break;
                            case "SquareKilometer":
                                result = squareFeet.toSquareKilometer();
                                break;
                            case "SquareMeter":
                                result = squareFeet.toSquareMeter();
                                break;
                            case "SquareMile":
                                result = squareFeet.toSquareMile();
                                break;
                            case "SquareMillimeter":
                                result = squareFeet.toSquareMillimeter();
                                break;
                            case "SquareYard":
                                result = squareFeet.toSquareYard();
                                break;
                        }
                        break;
                    case "SquareInch":
                        SquareInch squareInch = new SquareInch(value);
                        switch (to) {
                            case "Acres":
                                result = squareInch.toAcres();
                                break;
                            case "Hectares":
                                result = squareInch.toHectares();
                                break;
                            case "SquareCentimeter":
                                result = squareInch.toSquareCentimeter();
                                break;
                            case "SquareFeet":
                                result = squareInch.toSquareFeet();
                                break;
                            case "SquareInch":
                                result = squareInch.toSquareInch();
                                break;
                            case "SquareKilometer":
                                result = squareInch.toSquareKilometer();
                                break;
                            case "SquareMeter":
                                result = squareInch.toSquareMeter();
                                break;
                            case "SquareMile":
                                result = squareInch.toSquareMile();
                                break;
                            case "SquareMillimeter":
                                result = squareInch.toSquareMillimeter();
                                break;
                            case "SquareYard":
                                result = squareInch.toSquareYard();
                                break;
                        }
                        break;
                    case "SquareKilometer":
                        SquareKilometer squareKilometer = new SquareKilometer(value);
                        switch (to) {
                            case "Acres":
                                result = squareKilometer.toAcres();
                                break;
                            case "Hectares":
                                result = squareKilometer.toHectares();
                                break;
                            case "SquareCentimeter":
                                result = squareKilometer.toSquareCentimeter();
                                break;
                            case "SquareFeet":
                                result = squareKilometer.toSquareFeet();
                                break;
                            case "SquareInch":
                                result = squareKilometer.toSquareInch();
                                break;
                            case "SquareKilometer":
                                result = squareKilometer.toSquareKilometer();
                                break;
                            case "SquareMeter":
                                result = squareKilometer.toSquareMeter();
                                break;
                            case "SquareMile":
                                result = squareKilometer.toSquareMile();
                                break;
                            case "SquareMillimeter":
                                result = squareKilometer.toSquareMillimeter();
                                break;
                            case "SquareYard":
                                result = squareKilometer.toSquareYard();
                                break;
                        }
                        break;
                    case "SquareMeter":
                        SquareMeter squareMeter = new SquareMeter(value);
                        switch (to) {
                            case "Acres":
                                result = squareMeter.toAcres();
                                break;
                            case "Hectares":
                                result = squareMeter.toHectares();
                                break;
                            case "SquareCentimeter":
                                result = squareMeter.toSquareCentimeter();
                                break;
                            case "SquareFeet":
                                result = squareMeter.toSquareFeet();
                                break;
                            case "SquareInch":
                                result = squareMeter.toSquareInch();
                                break;
                            case "SquareKilometer":
                                result = squareMeter.toSquareKilometer();
                                break;
                            case "SquareMeter":
                                result = squareMeter.toSquareMeter();
                                break;
                            case "SquareMile":
                                result = squareMeter.toSquareMile();
                                break;
                            case "SquareMillimeter":
                                result = squareMeter.toSquareMillimeter();
                                break;
                            case "SquareYard":
                                result = squareMeter.toSquareYard();
                                break;
                        }
                        break;
                    case "SquareMile":
                        SquareMile squareMile = new SquareMile(value);
                        switch (to) {
                            case "Acres":
                                result = squareMile.toAcres();
                                break;
                            case "Hectares":
                                result = squareMile.toHectares();
                                break;
                            case "SquareCentimeter":
                                result = squareMile.toSquareCentimeter();
                                break;
                            case "SquareFeet":
                                result = squareMile.toSquareFeet();
                                break;
                            case "SquareInch":
                                result = squareMile.toSquareInch();
                                break;
                            case "SquareKilometer":
                                result = squareMile.toSquareKilometer();
                                break;
                            case "SquareMeter":
                                result = squareMile.toSquareMeter();
                                break;
                            case "SquareMile":
                                result = squareMile.toSquareMile();
                                break;
                            case "SquareMillimeter":
                                result = squareMile.toSquareMillimeter();
                                break;
                            case "SquareYard":
                                result = squareMile.toSquareYard();
                                break;
                        }
                        break;
                    case "SquareMillimeter":
                        SquareMillimeter squareMillimeter = new SquareMillimeter(value);
                        switch (to) {
                            case "Acres":
                                result = squareMillimeter.toAcres();
                                break;
                            case "Hectares":
                                result = squareMillimeter.toHectares();
                                break;
                            case "SquareCentimeter":
                                result = squareMillimeter.toSquareCentimeter();
                                break;
                            case "SquareFeet":
                                result = squareMillimeter.toSquareFeet();
                                break;
                            case "SquareInch":
                                result = squareMillimeter.toSquareInch();
                                break;
                            case "SquareKilometer":
                                result = squareMillimeter.toSquareKilometer();
                                break;
                            case "SquareMeter":
                                result = squareMillimeter.toSquareMeter();
                                break;
                            case "SquareMile":
                                result = squareMillimeter.toSquareMile();
                                break;
                            case "SquareMillimeter":
                                result = squareMillimeter.toSquareMillimeter();
                                break;
                            case "SquareYard":
                                result = squareMillimeter.toSquareYard();
                                break;
                        }
                        break;
                    case "SquareYard":
                        SquareYard squareYard = new SquareYard(value);
                        switch (to) {
                            case "Acres":
                                result = squareYard.toAcres();
                                break;
                            case "Hectares":
                                result = squareYard.toHectares();
                                break;
                            case "SquareCentimeter":
                                result = squareYard.toSquareCentimeter();
                                break;
                            case "SquareFeet":
                                result = squareYard.toSquareFeet();
                                break;
                            case "SquareInch":
                                result = squareYard.toSquareInch();
                                break;
                            case "SquareKilometer":
                                result = squareYard.toSquareKilometer();
                                break;
                            case "SquareMeter":
                                result = squareYard.toSquareMeter();
                                break;
                            case "SquareMile":
                                result = squareYard.toSquareMile();
                                break;
                            case "SquareMillimeter":
                                result = squareYard.toSquareMillimeter();
                                break;
                            case "SquareYard":
                                result = squareYard.toSquareYard();
                                break;
                        }
                        break;
                }
                break;
            case "Temperature":
                switch (from) {
                    case "DegreesCelsius":
                        DegreesCelsius degreesCelsius = new DegreesCelsius(value);
                        switch (to) {
                            case "DegreesCelsius":
                                result = degreesCelsius.toDegreesCelsius();
                                break;
                            case "DegreesFahrenheit":
                                result = degreesCelsius.toDegreesFahrenheit();
                                break;
                            case "Kelvin":
                                result = degreesCelsius.toKelvin();
                                break;
                        }
                        break;
                    case "DegreesFahrenheit":
                        DegreesFahrenheit degreesFahrenheit = new DegreesFahrenheit(value);
                        switch (to) {
                            case "DegreesCelsius":
                                result = degreesFahrenheit.toDegreesCelsius();
                                break;
                            case "DegreesFahrenheit":
                                result = degreesFahrenheit.toDegreesFahrenheit();
                                break;
                            case "Kelvin":
                                result = degreesFahrenheit.toKelvin();
                                break;
                        }
                        break;
                    case "Kelvin":
                        Kelvin kelvin = new Kelvin(value);
                        switch (to) {
                            case "DegreesCelsius":
                                result = kelvin.toDegreesCelsius();
                                break;
                            case "DegreesFahrenheit":
                                result = kelvin.toDegreesFahrenheit();
                                break;
                            case "Kelvin":
                                result = kelvin.toKelvin();
                                break;
                        }
                        break;
                }
                break;
            case "Velocity":
                switch (from) {
                    case "Centimeterpersecond":
                        Centimeterpersecond centimeterpersecond = new Centimeterpersecond(value);
                        switch (to) {
                            case "Centimeterpersecond":
                                result = centimeterpersecond.toCentimeterpersecond();
                                break;
                            case "Feetpersecond":
                                result = centimeterpersecond.toFeetpersecond();
                                break;
                            case "Kilometerpersecond":
                                result = centimeterpersecond.toKilometerpersecond();
                                break;
                            case "Knots":
                                result = centimeterpersecond.toKnots();
                                break;
                            case "Meterpersecond":
                                result = centimeterpersecond.toMeterpersecond();
                                break;
                            case "Milepersecond":
                                result = centimeterpersecond.toMilepersecond();
                                break;
                        }
                        break;
                    case "Feetpersecond":
                        Feetpersecond feetpersecond = new Feetpersecond(value);
                        switch (to) {
                            case "Centimeterpersecond":
                                result = feetpersecond.toCentimeterpersecond();
                                break;
                            case "Feetpersecond":
                                result = feetpersecond.toFeetpersecond();
                                break;
                            case "Kilometerpersecond":
                                result = feetpersecond.toKilometerpersecond();
                                break;
                            case "Knots":
                                result = feetpersecond.toKnots();
                                break;
                            case "Meterpersecond":
                                result = feetpersecond.toMeterpersecond();
                                break;
                            case "Milepersecond":
                                result = feetpersecond.toMilepersecond();
                                break;
                        }
                        break;
                    case "Kilometerpersecond":
                        Kilometerpersecond kilometerpersecond = new Kilometerpersecond(value);
                        switch (to) {
                            case "Centimeterpersecond":
                                result = kilometerpersecond.toCentimeterpersecond();
                                break;
                            case "Feetpersecond":
                                result = kilometerpersecond.toFeetpersecond();
                                break;
                            case "Kilometerpersecond":
                                result = kilometerpersecond.toKilometerpersecond();
                                break;
                            case "Knots":
                                result = kilometerpersecond.toKnots();
                                break;
                            case "Meterpersecond":
                                result = kilometerpersecond.toMeterpersecond();
                                break;
                            case "Milepersecond":
                                result = kilometerpersecond.toMilepersecond();
                                break;
                        }
                        break;
                    case "Knots":
                        Knots knots = new Knots(value);
                        switch (to) {
                            case "Centimeterpersecond":
                                result = knots.toCentimeterpersecond();
                                break;
                            case "Feetpersecond":
                                result = knots.toFeetpersecond();
                                break;
                            case "Kilometerpersecond":
                                result = knots.toKilometerpersecond();
                                break;
                            case "Knots":
                                result = knots.toKnots();
                                break;
                            case "Meterpersecond":
                                result = knots.toMeterpersecond();
                                break;
                            case "Milepersecond":
                                result = knots.toMilepersecond();
                                break;
                        }
                        break;
                    case "Meterpersecond":
                        Meterpersecond meterpersecond = new Meterpersecond(value);
                        switch (to) {
                            case "Centimeterpersecond":
                                result = meterpersecond.toCentimeterpersecond();
                                break;
                            case "Feetpersecond":
                                result = meterpersecond.toFeetpersecond();
                                break;
                            case "Kilometerpersecond":
                                result = meterpersecond.toKilometerpersecond();
                                break;
                            case "Knots":
                                result = meterpersecond.toKnots();
                                break;
                            case "Meterpersecond":
                                result = meterpersecond.toMeterpersecond();
                                break;
                            case "Milepersecond":
                                result = meterpersecond.toMilepersecond();
                                break;
                        }
                        break;
                    case "Milepersecond":
                        Milepersecond milepersecond = new Milepersecond(value);
                        switch (to) {
                            case "Centimeterpersecond":
                                result = milepersecond.toCentimeterpersecond();
                                break;
                            case "Feetpersecond":
                                result = milepersecond.toFeetpersecond();
                                break;
                            case "Kilometerpersecond":
                                result = milepersecond.toKilometerpersecond();
                                break;
                            case "Knots":
                                result = milepersecond.toKnots();
                                break;
                            case "Meterpersecond":
                                result = milepersecond.toMeterpersecond();
                                break;
                            case "Milepersecond":
                                result = milepersecond.toMilepersecond();
                                break;
                        }
                        break;
                }
                break;
            case "Pressure":
                switch (from) {
                    case "Atmosphere":
                        Atmosphere atmosphere = new Atmosphere(value);
                        switch (to) {
                            case "Atmosphere":
                                result = atmosphere.toAtmosphere();
                                break;
                            case "Bar":
                                result = atmosphere.toBar();
                                break;
                            case "KiloPascal":
                                result = atmosphere.toKiloPascal();
                                break;
                            case "Millimeterofmercury":
                                result = atmosphere.toMillimeterofmercury();
                                break;
                            case "Pascal":
                                result = atmosphere.toPascal();
                                break;
                            case "PoundperSquareInchPSI":
                                result = atmosphere.toPoundperSquareInchPSI();
                                break;
                        }
                        break;
                    case "Bar":
                        Bar bar = new Bar(value);
                        switch (to) {
                            case "Atmosphere":
                                result = bar.toAtmosphere();
                                break;
                            case "Bar":
                                result = bar.toBar();
                                break;
                            case "KiloPascal":
                                result = bar.toKiloPascal();
                                break;
                            case "Millimeterofmercury":
                                result = bar.toMillimeterofmercury();
                                break;
                            case "Pascal":
                                result = bar.toPascal();
                                break;
                            case "PoundperSquareInchPSI":
                                result = bar.toPoundperSquareInchPSI();
                                break;
                        }
                        break;
                    case "KiloPascal":
                        KiloPascal kiloPascal = new KiloPascal(value);
                        switch (to) {
                            case "Atmosphere":
                                result = kiloPascal.toAtmosphere();
                                break;
                            case "Bar":
                                result = kiloPascal.toBar();
                                break;
                            case "KiloPascal":
                                result = kiloPascal.toKiloPascal();
                                break;
                            case "Millimeterofmercury":
                                result = kiloPascal.toMillimeterofmercury();
                                break;
                            case "Pascal":
                                result = kiloPascal.toPascal();
                                break;
                            case "PoundperSquareInchPSI":
                                result = kiloPascal.toPoundperSquareInchPSI();
                                break;
                        }
                        break;
                    case "Millimeterofmercury":
                        Millimeterofmercury millimeterofmercury = new Millimeterofmercury(value);
                        switch (to) {
                            case "Atmosphere":
                                result = millimeterofmercury.toAtmosphere();
                                break;
                            case "Bar":
                                result = millimeterofmercury.toBar();
                                break;
                            case "KiloPascal":
                                result = millimeterofmercury.toKiloPascal();
                                break;
                            case "Millimeterofmercury":
                                result = millimeterofmercury.toMillimeterofmercury();
                                break;
                            case "Pascal":
                                result = millimeterofmercury.toPascal();
                                break;
                            case "PoundperSquareInchPSI":
                                result = millimeterofmercury.toPoundperSquareInchPSI();
                                break;
                        }
                        break;
                    case "Pascal":
                        Pascal pascal = new Pascal(value);
                        switch (to) {
                            case "Atmosphere":
                                result = pascal.toAtmosphere();
                                break;
                            case "Bar":
                                result = pascal.toBar();
                                break;
                            case "KiloPascal":
                                result = pascal.toKiloPascal();
                                break;
                            case "Millimeterofmercury":
                                result = pascal.toMillimeterofmercury();
                                break;
                            case "Pascal":
                                result = pascal.toPascal();
                                break;
                            case "PoundperSquareInchPSI":
                                result = pascal.toPoundperSquareInchPSI();
                                break;
                        }
                        break;
                    case "PoundperSquareInchPSI":
                        PoundperSquareInchPSI poundperSquareInchPSI = new PoundperSquareInchPSI(value);
                        switch (to) {
                            case "Atmosphere":
                                result = poundperSquareInchPSI.toAtmosphere();
                                break;
                            case "Bar":
                                result = poundperSquareInchPSI.toBar();
                                break;
                            case "KiloPascal":
                                result = poundperSquareInchPSI.toKiloPascal();
                                break;
                            case "Millimeterofmercury":
                                result = poundperSquareInchPSI.toMillimeterofmercury();
                                break;
                            case "Pascal":
                                result = poundperSquareInchPSI.toPascal();
                                break;
                            case "PoundperSquareInchPSI":
                                result = poundperSquareInchPSI.toPoundperSquareInchPSI();
                                break;
                        }
                        break;
                }
                break;
        }
    }

    public double getResult() {
        return result;
    }
}
