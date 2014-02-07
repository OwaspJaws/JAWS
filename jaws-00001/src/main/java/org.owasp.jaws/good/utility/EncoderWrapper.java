package org.owasp.jaws.good.utility;

import org.owasp.esapi.Encoder;
import org.owasp.esapi.reference.DefaultEncoder;

/**
 * @author Sam Theys
 */
public class EncoderWrapper {

    public static String encodeForHTML(String stringToEncode) {
        return DefaultEncoder.getInstance().encodeForHTML(stringToEncode);
    }

}
