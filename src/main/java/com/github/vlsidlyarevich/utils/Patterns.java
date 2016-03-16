package com.github.vlsidlyarevich.utils;

public class Patterns {

    public static final String WORD_PATTERN = "\\b(\\/)?[A-z]+((-[A-z]+)+|(\\/[A-z]+))?\\b(\\([A-z]+\\))?(\\s\\((SEQ ID NO: \\d+\\))|(seq id no: \\d+\\)))?";
    public static final String SEQ_PATTERN_WITHOUT_ID = "^((\\/)([abcdefghiklmnpqrstvwxy]{25,})|([abcdefghiklmnpqrstvwxy]{25,}))((((\\/)|\\s)[abcdefghiklmnpqrstvwxy]+)?)(\\([abcdefghiklmnpqrstvwx]+\\))?$";
    public static final String SEQ_PATTERN_WITH_ID = "^((\\/)([abcdefghiklmnpqrstvwxy]+)|([abcdefghiklmnpqrstvwxy]+))((((\\/)|\\s)[abcdefghiklmnpqrstvwxy]+)?)(\\([abcdefghiklmnpqrstvwx]+\\))?(\\s\\((seq id no: \\d+\\)))$";
    public static final String SEQ_PATTERN_AMIN= "^(ala|arg|asn|asp|cys|gln|glu|gly|his|ile|leu|lys|met|phe|pro|ser|thr|trp|tyr|val)(([\\-\\,\\\\\\|\\/])(ala|arg|asn|asp|cys|gln|glu|gly|his|ile|leu|lys|met|phe|pro|ser|thr|trp|tyr|val)){2,}$";
    public static final String SEQ_PATTERN_NUC_WITHOUT_ID="^((\\/)([actg]{6,})|([actg]{6,}))((((\\/)|\\s)[actg]+)?)(\\([actg]+\\))?$";
}
