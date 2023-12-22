package samples.javafx.model;

/**
 * Created by nuu on 19.12.2016.
 */
public class FifoPuffer {

    private int[] buffer;
    private int cursor;
    private int capacity;

    /**
     * Constructor.
     * @param capacity The capacitiy the puffer will have.
     */
    public FifoPuffer(int capacity)
    {
        this.capacity = capacity;
        buffer = new int[capacity];
        cursor = -1;
    }

    /**
     * Puts a number into the puffer.
     * @param zahl The number to put.
     * @throws Exception Exception when the puffer is full (full means: capacity was reached)
     */
    public void put(int zahl) throws Exception
    {
        if (cursor == capacity - 1)
            throw new Exception("Der Puffer ist voll.");

        buffer[++cursor] = zahl;
    }

    /**
     * Removes the first number from the buffer.
     * @return Returns the number which was removed from the puffer.
     * @throws Exception Exception when the puffer is empty.
     */
    public int get() throws Exception
    {
        if (cursor == -1)
            throw new Exception("Der Puffer ist leer.");

        return getFirst();
    }

    /**
     * Gets all the numbers from the puffer
     * @return A String with all the numbers, separated by comma.
     * @throws Exception Exception when the puffer is empty.
     */
    public String getAll() throws  Exception
    {
        if (cursor == -1)
            throw new Exception("Der Puffer ist leer.");

        StringBuilder result = new StringBuilder();

        for (int i = 0; i <= cursor; i++)
        {
            result.append(buffer[i]);
            if (i < cursor)
                result.append(",");
        }

        return result.toString();
    }

    private int getFirst()
    {
        // make a temporary copy of the buffer
        int[] tmp = buffer.clone();


        // re-arrange buffer with the help of the copy
        for (int i = 1; i < capacity; i++)
            buffer[i-1] = tmp[i];

        cursor--;

        // first element can still be found in the copy
        return tmp[0];
    }
}
