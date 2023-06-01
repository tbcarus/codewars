/*The rgb function is incomplete. Complete it so that passing in RGB decimal values will result in a hexadecimal
representation being returned. Valid decimal values for RGB are 0 - 255. Any values that fall out of that range must be
 rounded to the closest valid value.

        Note: Your answer should always be 6 characters long, the shorthand with 3 will not work here.

        The following are examples of expected output values:

        RgbToHex.rgb(255, 255, 255) // returns FFFFFF
        RgbToHex.rgb(255, 255, 300) // returns FFFFFF
        RgbToHex.rgb(0, 0, 0)       // returns 000000
        RgbToHex.rgb(148, 0, 211)   // returns 9400D3*/

package RGBToHexConversion;

import static java.lang.Integer.toHexString;

public class RgbToHex {

    public static String rgb(int r, int g, int b) {
        r = r > 255 ? 255 : Math.max(r, 0);
        g = g > 255 ? 255 : Math.max(g, 0);
        b = b > 255 ? 255 : Math.max(b, 0);
        return ((toHexString(r).length() == 2 ? toHexString(r) : 0 + toHexString(r))
                + (toHexString(g).length() == 2 ? toHexString(g) : 0 + toHexString(g))
                + (toHexString(b).length() == 2 ? toHexString(b) : 0 + toHexString(b)))
                .toUpperCase();
    }
}
