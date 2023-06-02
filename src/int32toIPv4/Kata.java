/*This address has 4 octets where each octet is a single byte (or 8 bits).

        1st octet 128 has the binary representation: 10000000
        2nd octet 32 has the binary representation: 00100000
        3rd octet 10 has the binary representation: 00001010
        4th octet 1 has the binary representation: 00000001
        So 128.32.10.1 == 10000000.00100000.00001010.00000001

        Because the above IP address has 32 bits, we can represent it as the unsigned 32 bit number: 2149583361

        Complete the function that takes an unsigned 32 bit number and returns a string representation of its IPv4 address.

        Examples
        2149583361 ==> "128.32.10.1"
        32         ==> "0.0.0.32"
        0          ==> "0.0.0.0"*/

package int32toIPv4;

public class Kata {

    public static String longToIP(long ip) {
        // Java doesn't have uint32, so here we use long to represent int32
        String str = Long.toBinaryString(ip);
        int n = str.length();
        String[] b = new String[4];
        for (int i = 0; i < 4; i++) {
            try {
                b[i] = str.substring(n - 8 * (i + 1), n - 8 * i);
            } catch (StringIndexOutOfBoundsException exc) {
                b[i] = (n > 8 * i) && (n <= 8 * (i + 1)) ? str.substring(0, n - 8 * i) : "0";
            }
        }
        String dot = "";
        StringBuilder ipStr = new StringBuilder();
        for (int i = 3; i >= 0; i--) {
            ipStr.append(dot);
            dot = ".";
            ipStr.append(Integer.parseInt(b[i], 2));
        }

        return ipStr.toString(); // do it!
//        return String.format("%d.%d.%d.%d", ip>>>24, (ip>>16)&0xff, (ip>>8)&0xff, ip&0xff);
    }
}