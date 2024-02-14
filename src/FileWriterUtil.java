import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.prefs.Preferences;

public class FileWriterUtil {
    private static final String PACKAGE_NUMBER_KEY = "nextPackageNumber";
    private static final String NIR_NUMBER_KEY="nextNIRNumber";
    private static final String NR_FURNIZOR="numereFurnizori";
    private static int numarFurnizor=1;
    private static int numarColet=1;
    private static int numarNIR=1000;
    private static Preferences preferences=Preferences.userNodeForPackage(FileWriterUtil.class);
    private static int getNumarColet(){
        numarColet= preferences.getInt(PACKAGE_NUMBER_KEY,1);
        preferences.putInt(PACKAGE_NUMBER_KEY,numarColet+1);
        return numarColet;
    }
  /* protected static int getNumarFurnizor(){
        numarFurnizor= preferences.getInt(NR_FURNIZOR,1);
        preferences.putInt(NR_FURNIZOR,numarFurnizor+1);
        return numarFurnizor;
    }

   */

    public static int getNumarNIR(){
        numarNIR= preferences.getInt(NIR_NUMBER_KEY,1000);
        preferences.putInt(NIR_NUMBER_KEY,numarNIR+1);
        return numarNIR;
    }

    public static void writeDataFromTable(JTable table) throws IOException {
        FileWriter writer = new FileWriter("listaColete.txt", true);
        for (int row = 0; row < table.getRowCount(); row++) {
            int numarPachet=getNumarColet();
            StringBuilder line = new StringBuilder();
            line.append(numarPachet).append(".");
            for (int col = 0; col < table.getColumnCount(); col++) {
                Object cellValue = table.getValueAt(row, col);
                line.append(cellValue != null ? cellValue.toString() : "").append("\t");
            }
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            line.append(dtf.format(now));
            writer.write(line.toString().trim());
            writer.write(System.lineSeparator());
        }

        writer.close();
    }
}
