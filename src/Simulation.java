public class Simulation {
    public static void main(String[] args) {
        Encryptor key1 = new Encryptor(3,4);
        System.out.println(key1.encryptMessage("What are you doing next weekend?"));

        Encryptor key2 = new Encryptor(6,5);
        System.out.println(key1.encryptMessage("This one time I was trying to do a handstand and fell backwards and landed on my shoe. It hurt! I won't try that again."));

        Encryptor key3 = new Encryptor(3,2);
        System.out.println(key3.decryptMessage("Ti hsiscn ofietdnia!Bl e nto helo okotAu!A"));

        Encryptor key4 = new Encryptor(5,5);
        System.out.println(key4.decryptMessage("Tite hsocmi presa es  stsaneregtd see J  nfaBidomonee  d ftm.cuhe alisBr,ssaieecgllstelft!  -rAwsduA"));

        Encryptor key5 = new Encryptor(6,5);
        System.out.println(key5.decryptMessage("Meottai ooufdsl rtdcsrnelh e r etWwht hhiihmselgro.nlhen    sld tmc egoehsne  otttcbous oacHusAAkoloAA?ploAA eynAA f !AA"));

        Encryptor key6 = new Encryptor(9,8);
        System.out.println(key6.decryptMessage("Io ihscnongeoesofn rnn  do.cac poir rprirfnmTyhyso gahpyp ce tit,tteniis  siea o,pc gpttr rotirihmkonhneoeancveasn toee le iiwsro nononstrrtffn atttencxlseoe oitl x rfwp.yptanonh ,l,nar eI a  tmardoiiai stennnlvk ealyit real  zid rcaaaeeeatkinudsc e ndt  icxtt hpcpitoeaoaahp  xcrrnehbptceo tc t  sriird pisinoyoirn gfnpetettio.tssvehnr i eereamEonlnf lannoftert eetoite tl  unondhlctltrceeioode.en gn -r  iiitabcFbenbe eeoustlnw pr annn  patlsc uusne ,rsssedcr ycueuoheaphasdmnantel o is imla-ecoeoey rnc eyoIsotrkr rts  yeaai idtpytntibeht e hslceigdam er oe l.p ymnnbg otpests  r-dtshstb d iaoehuaeeoguset snnets ,wic   ik egrswpneflnyciogyolephesearsi dmi te lr.edcisale ,eooonsqA rmnud uncapar ai obulcsrranlt ekeeut naceehrhrtsr  eooe iymw vrcclpeikiiiaytstedzpn  shyeei dta  ddeeehgtp brribthuAyi puoosA gtit reAtioe uirAhn nnnzsAeartoae.A testudAAooc  t AA"));

        Encryptor personal = new Encryptor(4,3);
        System.out.println(personal.encryptMessage("What is life? Life is life, an English word that can be translated to other languages."));
        System.out.println(personal.decryptMessage("Wtsih  faile?i   filLesif  geaEl,nniswdhho a rtt nerc  aabtnst  letoadoth naelggrauesAAA.AAAAAAA"));
    }
}
