package com.samasend;

/**
 *
 * @author Sam As End
 */
public class Country {

    private String name;

    private int rainFall;
    private int gdp;
    private int politicalGrowth;
    private int growthLevel;
    private int annualProduct;
    
    private float status = 0;

    public Country(String name) {
        this.name = name;
    }

    public void calculateState() {
        status = (rainFall + gdp + politicalGrowth + growthLevel + annualProduct);
        status /= 5;
    }

    @Override
    public String toString() {
        if(status > 90) {
            return "Exellent";
        }
        else if(status > 80) {
            return "Very Good";
        }
        else if(status > 70) {
            return "Good";
        }
        else if(status > 60) {
            return "Fair";
        }
        else if(status > 50) {
            return "Poor";
        }
        else {
            return "Bad";
        }
        
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRainFall() {
        return rainFall;
    }

    public void setRainFall(int rainFall) throws Exception {
        if(rainFall > 100 || rainFall < 0) {
            throw new Exception("Rainfall must be b/n 0 and 100");
        }
        this.rainFall = rainFall;
    }

    public int getGdp() {
        return gdp;
    }

    public void setGdp(int gdp) throws Exception {
        if(gdp > 100 || gdp < 0) {
            throw new Exception("GDP must be b/n 0 and 100");
        }
        this.gdp = gdp;
    }

    public int getPoliticalGrowth() {
        return politicalGrowth;
    }

    public void setPoliticalGrowth(int politicalGrowth) throws Exception {
        if(politicalGrowth > 100 || politicalGrowth < 0) {
            throw new Exception("Political Growth must be b/n 0 and 100");
        }
        this.politicalGrowth = politicalGrowth;
    }

    public int getGrowthLevel() {
        return growthLevel;
    }

    public void setGrowthLevel(int growthLevel) throws Exception {
        if(growthLevel > 100 || growthLevel < 0) {
            throw new Exception("Growth Level must be b/n 0 and 100");
        }
        this.growthLevel = growthLevel;
    }

    public int getAnnualProduct() {
        return annualProduct;
    }

    public void setAnnualProduct(int annualProduct) throws Exception {
        if(annualProduct > 100 || annualProduct < 0) {
            throw new Exception("Annual Product must be b/n 0 and 100");
        }
        this.annualProduct = annualProduct;
    }

    public float getStatus() {
        return status;
    }

}
