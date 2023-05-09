package workers;
import com.bethecoder.ascii_table.ASCIITable;
import java.io.*;
import java.util.ArrayList;
// Дана ведомость расчета заработной платы (файл "data/workers").
// Рассчитайте зарплату всех работников, зная что они получат полный оклад,
// если отработают норму часов. Если же они отработали меньше нормы,
// то их ЗП уменьшается пропорционально, а за каждый час переработки они получают
// удвоенную ЗП, пропорциональную норме.
// Кол-во часов, которые были отработаны, указаны в файле "data/hours_of"
public class Solution {

    static void fillWorkersList (ArrayList <Worker> workers)throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader("workers.txt"));
        String line = reader.readLine();//прочитать и забыть первую строку, там нет информации.
        while ((line = reader.readLine()) != null) {
            String line2 = line.replaceAll("\\s+", " ");
            String[] string = line2.split(" ");
            String name = string[0];
            String surname = string[1];
            int salary= Integer.parseInt(string[2]);
            String position = string[3];
            int hoursNorm = Integer.parseInt(string[4]);
            Worker worker = new Worker(name,surname,salary,position,hoursNorm);
            workers.add(worker);
        }
        reader.close();
    }
    static void readHoursFact(ArrayList<Worker> workers) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("hours_of.txt"));
        String line = reader.readLine();//прочитать и забыть первую строку, там нет информации.
        while ((line = reader.readLine()) != null){
            String line2 = line.replaceAll("\\s+", " ");
            String[] string = line2.split(" ");//split(line);
            String name = string[0];
            String surname = string[1];
            int hoursFact = Integer.parseInt(string[2]);
            for (Worker worker : workers) {
                if (worker.getName().equals(name) && worker.getSurname().equals(surname)){
                    worker.setHoursFact(hoursFact);
                    break;
                }
            }
        }
        reader.close();
    }

      static void countSalary(ArrayList<Worker> workers){
          for (Worker p : workers){
              p.resultSalary();
          }
      }

    static File fileSalary(ArrayList<Worker> workers) throws IOException {
        File file = new File("SalaryResult.txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        writer.write("Имя     Фамилия      Зарплата к выплате\n");
        for (Worker p : workers) {
            writer.write(p.getName() + "  " + p.getSurname() + "  " + p.getResultSalary() + "\n");
        }
        writer.close();

        return file;
    }

    static void print(ArrayList<Worker> workers){
        String[] tableHeaders = {"Имя", "Фамилия", "Должность", "Зарплата к выплате"};
        String[][] tableData = new String[workers.size()][tableHeaders.length];
        for (int i = 0; i < workers.size(); i++) {
            tableData[i][0] = workers.get(i).getName();
            tableData[i][1] = workers.get(i).getSurname();
            tableData[i][2] = workers.get(i).getPosition();
            tableData[i][3] = String.valueOf(workers.get(i).getResultSalary());
        }
        ASCIITable.getInstance().printTable(tableHeaders, tableData);
    }

    public static void main(String[] args) throws IOException {
        ArrayList<Worker> workers = new ArrayList<>();
        //Заполняем поля каждого работника из одного файла
        fillWorkersList(workers);
        //Заполняем поле фактически отработанного времени из второго файла
        readHoursFact(workers);
        //Расчет зарплаты
        countSalary(workers);
        fileSalary(workers);
       print(workers);
    }
}
