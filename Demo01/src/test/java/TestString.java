import org.apache.commons.io.EndianUtils;
import org.junit.Test;

public class TestString {
    // 32bit 4byte
    byte[] bts = {0xb9 & 0x7f, 0x2, 0xed & 0x7f, 0x63};
    char[] chs = {0xb9, 0x2, 0xed, 0x63};

    @Test
    public void testStringConstruct() {
        // byte 范围  -128~127
        // char 范围  2byte
        String str_from_bytes = new String(bts);
        String str_from_chars = new String(chs);  //为了能存下0xff这样的字符，String底层维护的是char[]
        System.out.println("===REAL:");
        for (char e : chs) {
            // Unsigned int in Java: Java does not have unsigned data types
            System.out.printf("--0x%x", (short) e);
        }
        System.out.println("\n===ERR OUT");
        for (byte e : str_from_chars.getBytes()) {
            System.out.printf("--0x%x", e);
        }
        // c2b9 11000010_10111001  //src: b9
        // c3ad 11000011_10101101  //src: ed  11101101

        // 传入2byte的char，但实际的有效位是0xff长度，即使(无符号的)单字节。
        // value[i] = (char)(ascii[i + offset] & 0xff);  String源码如左侧

        System.out.println("\nstr_from_bytes = " + str_from_bytes + "/---");
        System.out.println("str_from_chars = " + str_from_chars + "/---OK!");
    }

    @Test
    public void testStringTool() {
//        org.apache.commons.io.EndianUtils.readSwappedInteger(bts, 0);
        int res = 0;
        res = EndianUtils.readSwappedInteger(bts, 0);
        System.out.printf("raw: [%d], res: [%s] \n", 1668088377, res);
//        res = EndianUtils.readSwappedInteger(chs, 0);
//        System.out.println("res = " + res);
    }
}
