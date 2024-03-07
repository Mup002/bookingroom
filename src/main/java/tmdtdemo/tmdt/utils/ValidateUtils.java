package tmdtdemo.tmdt.utils;

import lombok.Builder;

@Builder
public class ValidateUtils {
    private Object value;
    private boolean required;
    private Integer maxLengrh;
    private String fieldName;
    private String regex;
    private boolean onlyNumber;
    private boolean isInteger;
    private Long max;

}
