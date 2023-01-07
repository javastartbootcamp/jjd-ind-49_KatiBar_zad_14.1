import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        String fileName = "liczby.txt";
        try {
            List<Integer> allNumbers = getAllNumbers(fileName);
            printInfo(allNumbers);
        } catch (FileNotFoundException e) {
            System.err.println("Brak pliku o nazwie: " + fileName);
        }
    }

    private static void printInfo(List<Integer> allNumbers) {
        Set<Integer> numbersSet = new HashSet<>(allNumbers);
        for (Integer uniqueNumber : numbersSet) {
            int count = getCounterForUniqueNumber(allNumbers, uniqueNumber);
            System.out.println(uniqueNumber + " - liczba wystąpień " + count);
        }
    }

    private static int getCounterForUniqueNumber(List<Integer> allNumbers, Integer uniqueNumber) {
        int count = 0;
        for (Integer number : allNumbers) {
            if (number.equals(uniqueNumber)) {
                count++;
            }
        }
        return count;
    }

    private static List<Integer> getAllNumbers(String fileName) throws FileNotFoundException {
        List<Integer> numbersList = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                numbersList.add(scanner.nextInt());
            }
        }
        return numbersList;
    }
}