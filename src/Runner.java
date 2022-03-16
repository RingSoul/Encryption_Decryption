public class Runner {
    public static void main(String[] args) {
        PersonalEncryptor pe = new PersonalEncryptor(3,3,5,2,0);
        System.out.println(pe.encrypt("abcdefghiabcdefg"));
    }
}
