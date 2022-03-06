package Company.Walmart;

import java.io.File;

/**
 * @author mmichaelbarboza
 * on 12:15 PM 3/6/2022
 * Time Taken:
 */
public class Check {

    public static void main(String[] args) {

    }

    public static class FileSystem implements AutoCloseable{

        @Override
        public void close() throws Exception {

        }

        public static void main(String[] args) throws Exception {
            try(FileSystem t = new FileSystem()){

            }
        }
    }
}
