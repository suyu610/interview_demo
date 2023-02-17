package com.uuorb.interview_demo.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class CalculateEntity implements Serializable {
    BigDecimal number;
    BigDecimal ratio;
    BigDecimal result;

    public void setResult(BigDecimal result) {
        this.result = result;
    }

    public BigDecimal getNumber() {
        return number;
    }

    public BigDecimal getRatio() {
        return ratio;
    }

    public BigDecimal getResult() {
        return result;
    }

    private CalculateEntity(Builder builder) {
        this.number = builder.number;
        this.ratio = builder.ratio;
        this.result = builder.result;
    }

    // builder
    public static class Builder {
        private  BigDecimal number;
        private  BigDecimal ratio;
        private  BigDecimal result;

        public Builder() {
        }
        public Builder number(BigDecimal number) {
            this.number = number;
            return this;
        }
        public Builder ratio(BigDecimal ratio) {
            this.ratio = ratio;
            return this;
        }
        public Builder result(BigDecimal result) {
            this.result = result;
            return this;
        }
        public CalculateEntity build() {
            return new CalculateEntity(this);
        }

    }

}
