public class PersonalEncryptor extends Encryptor {
    private int letterShift;
    private int rowShift;
    private int colShift;


    public PersonalEncryptor(int row, int col, int letterShift, int rowShift, int colShift) {
        super(row, col); // can use fillBlock(), getLetterBlock()
        this.letterShift = letterShift;
        this.rowShift = rowShift;
        this.colShift = colShift;
    }

    public String encryptBlock(String message)
    {
        String result = "";
        fillBlock(message); // same as Encryptor; empty blocks becomes "A"
        String[][] array = getLetterBlock(); // easy name, easy access
        // letter shift
        for (int r = 0; r < array.length; r++)
        {
            for (int c = 0; c < array[0].length; c++)
            {
                String current = array[r][c];
                char character = current.charAt(0);
                int newChar = (int) character + letterShift;
                array[r][c] = Character.toString(newChar);
            }
        }
        // row shift

        // column shift

        return result;
    }

    public String encryptMessage(String message)
    {
        String result = "";
        return result;
    }

    public String decryptMessage(String message)
    {
        String result = "";
        return result;
    }


}
