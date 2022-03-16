public class PersonalEncryptor extends Encryptor {
    private int letterShift;
    private int rowShift;
    private int colShift;


    public PersonalEncryptor(int row, int col, int letterShift, int rowShift, int colShift) {
        super(row, col); // can use fillBlock() and accessor methods (getLetterBlock, getNumRows, getNumCols)
        this.letterShift = letterShift;
        this.rowShift = rowShift;
        this.colShift = colShift;
    }

    // can be revised through refactoring (creating individual methods)
    public String encrypt(String message)
    {
        String result = "";
        while (message.equals("") == false)
        {
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
            for (int r = 0; r < array.length; r++)
            {
                String[] current = array[r];
                if (rowShift < 0) // shift left
                {
                    int shift = Math.abs(rowShift); // make a positive duplicate, easy for calculations
                    String[] temps = new String[shift];
                    for (int i = 0; i < shift; i++) // temps, those that would exceed bound when shifting
                    {
                        temps[i] = current[i]; // indices are the same
                    }
                    for (int i = 0; i < current.length - shift; i++) // shift (no need to worry about exceeding indices
                    {
                        current[i] = current[i + shift];
                    }
                    int index = 0; // for array temps
                    for (int i = current.length - shift; i < current.length; i++) // putting temps into their positions after the shift
                    {
                        current[i] = temps[index];
                        index++;
                    }
                }
                else if (rowShift > 0) // shift right
                { // no need to make a positive duplicate since it is already positive
                    String[] temps = new String[rowShift];
                    int index = 0; // for temp
                    for (int i = current.length - rowShift; i < current.length; i++) // temps, those that would exceed bound when shifting
                    {
                        temps[index] = current[i];
                        index++;
                    }
                    for (int i = current.length - 1; i >= rowShift; i--) // shift without worrying "out of bound"
                    {
                        current[i] = current[i - rowShift];
                    }
                    for (int i = 0; i < rowShift; i++) // those that would exceed bound, place them in appropriate positions
                    {
                        current[i] = temps[i]; // the indices are the same
                    }
                }
            }
            // column shift

            // add up all element (row-major order?)
            for (String[] list : array) {
                for (String element : list) {
                    result += element;
                }
            }
            // update
            if (message.length() > getNumRows() * getNumCols())
            {
                message = message.substring(getNumRows() * getNumCols());
            }
            else
            {
                message = "";
            }
        }
        return result;
    }

    public String decrypt(String message)
    {
        String result = "";

        return result;
    }


}
