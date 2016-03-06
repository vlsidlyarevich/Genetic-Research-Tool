package com.github.vlsidlyarevich.utils;

public class Patterns {

    public static final String WORD_PATTERN = "\\b(\\/)?[A-z]+((-[A-z]+)|(\\/[A-z]+))?\\b(\\([A-z]+\\))?(\\s\\((SEQ ID NO: \\d+\\)))?";
    public static final String SEQ_PATTERN_WITHOUT_ID = "^((\\/)([ABCDEFGHIKLMNPQRSTVWXY]{10,})|([ABCDEFGHIKLMNPQRSTVWXY]{10,}))((((\\/)|\\s)[ABCDEFGHIKLMNPQRSTVWXY]+)?)(\\([ABCDEFGHIKLMNPQRSTVWX]+\\))?$";
    public static final String SEQ_PATTERN_WITH_ID = "^((\\/)([ABCDEFGHIKLMNPQRSTVWXY]+)|([ABCDEFGHIKLMNPQRSTVWXY]+))((((\\/)|\\s)[ABCDEFGHIKLMNPQRSTVWXY]+)?)(\\([ABCDEFGHIKLMNPQRSTVWX]+\\))?(\\s\\((SEQ ID NO: \\d+\\)))$";
    public static final String SEQ_PATTERN_AMIN= "^(ala|arg|asn|asp|cys|gln|glu|gly|his|ile|leu|lys|met|phe|pro|ser|thr|trp|tyr|val)(([\\-\\,\\\\\\|\\/])(ala|arg|asn|asp|cys|gln|glu|gly|his|ile|leu|lys|met|phe|pro|ser|thr|trp|tyr|val))+$";
}
