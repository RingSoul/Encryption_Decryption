public class Runner {
    public static void main(String[] args) {
        PersonalEncryptor pe1 = new PersonalEncryptor(3,3,3,3,3);
        System.out.println(pe1.encrypt("The Moon is falling, so are we"));
        System.out.println(pe1.decrypt("W#rkPqhr#liovdl#oqjvd/ru##h#DDzDDhDD")); // based on console

        System.out.println();

        PersonalEncryptor pe2 = new PersonalEncryptor(4,4,4,4,4);
        System.out.println(pe2.encrypt("The world is spinning, it becomes pljom, a flipped \"world\" LOL"));
        System.out.println(pe2.decrypt("X{h$ls$wivmt$pwmrkxgr0$sm$fqrmiiwn$p$semtq$tp0jti{hShs&P$v$E&pPE"));

        System.out.println();

        PersonalEncryptor pe3 = new PersonalEncryptor(12, 65, 21, 65, 192);
        System.out.println(pe3.encrypt("These numbers are terrible large, (**&%&%^$^$%^% are some random characters~~~"));
        System.out.println(pe3.decrypt("\u0088\u0087VVVVVVVVVVzvVVVVVVVVVV5xVVVVVVVVVV\u0083\u0089VVVVVVVVVV\u008AzVVVVVVVVVV\u0082\u0087VVVVVVVVVVw\u0088VVVVVVVVVVz\u0093VVVVVVVVVV\u0087\u0093VVVVVVVVVV\u0088\u0093VVVVVVVVVV5VVVVVVVVVVVvVVVVVVVVVVV\u0087VVVVVVVVVVVzVVVVVVVVVVV5VVVVVVVVVVV\u0089VVVVVVVVVVVzVVVVVVVVVVV\u0087VVVVVVVVVVV\u0087VVVVVVVVVVV~VVVVVVVVVVVwVVVVVVVVVVV\u0081VVVVVVVVVVVzVVVVVVVVVVV5VVVVVVVVVVV\u0081VVVVVVVVVVVvVVVVVVVVVVV\u0087VVVVVVVVVVV|VVVVVVVVVVVzVVVVVVVVVVVAVVVVVVVVVVV5VVVVVVVVVVV=VVVVVVVVVVV?VVVVVVVVVVV?VVVVVVVVVVV;VVVVVVVVVVV:VVVVVVVVVVV;VVVVVVVVVVV:VVVVVVVVVVVsVVVVVVVVVVV9VVVVVVVVVVVsVVVVVVVVVVV9VVVVVVVVVVV:VVVVVVVVVVVsVVVVVVVVVVV:VVVVVVVVVVV5VVVVVVVVVVVvVVVVVVVVVVV\u0087VVVVVVVVVVVzVVVVVVVVVVV5VVVVVVVVVVV\u0088VVVVVVVVVVV\u0084VVVVVVVVVVV\u0082VVVVVVVVVVVzVVVVVVVVVVV5VVVVVVVVVVV\u0087VVVVVVVVVVVvVVVVVVVVVVV\u0083VVVVVVVVVVVyVVVVVVVVVVV\u0084VVVVVVVVVVV\u0082VVVVVVVVVVV5VVVVVVVVVVVixVVVVVVVVVV}}VVVVVVVVVVzvVVVVVVVVVV"));

        System.out.println();

        PersonalEncryptor pe4 = new PersonalEncryptor(34,12,43,1,24);
        System.out.println(pe4.encrypt("According a nonsense study published by me, sleep is necessary for human health and healthy human *&^&%^$ SLEEEEEEEEEP"));
        System.out.println(pe4.decrypt("K \u008F\u0090\u008C\u0099K\u008Cwllllllllllllllllllllllllll\u0099\u008FK\u009B\u009DK\u0093\u0099pllllllllllllllllllllllll\u008E\u009A¤\u008DK¤\u0093\u0090Kpllllllllllllllllllllllll\u008E\u0099K¤\u0094K\u0090\u008CUpllllllllllllllllllllllll\u009A\u009E\u009BK\u009E\u0091\u008C\u0097Qpllllllllllllllllllllllll\u009D\u0090 \u0098K\u009A\u0097\u009F\u0089pllllllllllllllllllllllll\u008F\u0099\u008D\u0090\u0099\u009D\u009F\u0093Qpllllllllllllllllllllllll\u0094\u009E\u0097W\u0090K\u0093¤Ppllllllllllllllllllllllll\u0099\u0090\u0094K\u008E\u0093KK\u0089pllllllllllllllllllllllll\u0092K\u009E\u009E\u0090 \u008C\u0093OpllllllllllllllllllllllllK\u009E\u0093\u0097\u009E\u0098\u0099 K{llllllllllllllllllllllll\u008C\u009F\u0090\u0090\u009E\u008C\u008F\u0098~lllllllllllllllllllllllll"));
    }
}
