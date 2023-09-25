////package com.vodafone.common.helpers.files;
////
////import java.io.BufferedReader;
////import java.io.File;
////import java.io.FileReader;
////import java.io.IOException;
////import java.util.ArrayList;
////import java.util.Arrays;
////import java.util.List;
////
////
////public class CsvReader {
////    private static FileUtil fileUtil = null;
////    private static File file = null;
////    private static List<String[]> table = new ArrayList<>();
////
////    public CsvReader() {
////        fileUtil = new FileUtil();
////    }
////
////    public static void main(String ar[]) {
////        CsvReader csv = new CsvReader();
////        readDataFromCSV("Total_SIMs.csv");
////        csv.printTableResult();
////    }
////
////    /**
////     * This method reads the data from a CSV file and
////     * stores it in the 'table' list as String arrays.
////     * @return
////     */
////
//////    public static String[] readDataFromCSV(String fileName) {
//////        List<String> table = new ArrayList<>();
//////        String extPath = fileUtil.readFile("testData/iap/overview", fileName);
//////        System.out.println("path: " + extPath);
//////        try (BufferedReader buffer = new BufferedReader(new FileReader(extPath))) {
//////            String line;
//////            while ((line = buffer.readLine()) != null) {
//////                String[] row = line.split(",");
//////                table.add(Arrays.toString(row));
//////            }
//////        } catch (IOException e) {
//////            e.printStackTrace();
//////        }
//////        System.out.println("table: " + table);
//////        return table.toArray(new String[0]);
//////    }
////
//////    public static List<String[]> readDataFromCSV(String fileName) {
//////        List<String[]> table = new ArrayList<>();
//////        String extPath = fileUtil.readFile("testData/iap/overview", fileName);
//////        System.out.println("path: " + extPath);
//////        try (BufferedReader buffer = new BufferedReader(new FileReader(extPath))) {
//////            String line;
//////            while ((line = buffer.readLine()) != null) {
//////                String[] row = line.split(",");
//////                table.add(row);
//////            }
//////        } catch (IOException e) {
//////            e.printStackTrace();
//////        }
//////        return table;
//////    }
////    public static List<String[]> readDataFromCSV(String fileName) {
////        table.clear();
////        String fileContent = fileUtil.readFile("testData/iap/overview", fileName);
////        System.out.println(fileContent);
////        String[] lines = fileContent.split("\\r?\\n");
////
////        for (String line : lines) {
////            String[] row = line.split(",");
////            table.add(row);
////        }
////        System.out.println(table.size());
////        return table;
////    }
////
//////    public static File getFile(String fileName) {
//////        String resP;
//////        synchronized (fileName.intern()) {
//////            String extFPath = fileUtil.searchDir(fileUtil.getProjDirFolder().getPath(), fileName);
//////            if (!extFPath.equals("")) {
//////                file = new File(extFPath);
//////            } else {
//////                resP = fileUtil.getResPath(fileName);
//////                if (resP.equals("")) {
//////                    throw new Error("File with name '" + fileName + "' not found.");
//////                }
//////                System.out.println("Extracting file with name: " + fileName + " and path >> " + resP);
//////                file = fileUtil.fileExtractor(resP, resP);
//////            }
//////            System.out.println("Reading file with path >> " + file);
//////        }
//////        return file;
//////    }
////
////    private void printTableResult() {
////        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
////        int arrayCounter = 0;
////        System.out.println("table size = " + table.size());
////        for (String[] row : table) {
////            System.out.println("Table Content for Record No." + arrayCounter);
////            for (String cell : row) System.out.print(cell + ", ");
////            System.out.println();
////            arrayCounter++;
////        }
////        System.out.println("################ test ###############");
////    }
////}
//package com.demoblaze.common.helpers.files;
//
//import com.vodafone.common.MyLogger;
//import com.vodafone.common.helpers.files.FileUtil;
//import org.apache.logging.log4j.core.Logger;
//
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.*;
//import java.util.stream.Collectors;
//
///**
// * implementation of this class are in 'CSVmanager' class
// *
// */
//public class CsvReader {
//    private static FileUtil fileUtil = null;
//    private static File f = null;
//    private static long rowCount = 0;
//    private static long colCount = 0;
//    private static Logger log = new MyLogger().getLogger();
//    private String filePath = "test.csv";
//
//
//    public CsvReader() {
//        fileUtil = new FileUtil();
//    }
//
//    /**
//     * extract csv file
//     *
//     * @param srcFile  source directory
//     * @param destFile destination directory
//     * @return extracted file object
//     */
//    public File getFile(String srcFile, String destFile) {
//        f = fileUtil.fileExtractor(srcFile, destFile);
//        return f;
//    }
//
//    /**
//     * read file and if not exist extract it
//     *
//     * @param fileName
//     * @return
//     */
//    public File readCsvFile(String fileName) {
//        File csv;
//        String resP;
//        synchronized (fileName.intern()) {
//            String extFPath = fileUtil.searchDir(fileUtil.getProjDirFolder().getPath(), fileName);
//            if (!extFPath.equals("")) csv = new File(extFPath);
//            else {
//                resP = fileUtil.getResPath(fileName);
//                if (resP.equals("")) throw new Error("File with name '" + fileName + "' not found.");
//                log.info("Extracting file with name:" + fileName + " and path >> " + resP);
//                csv = fileUtil.fileExtractor(resP, resP);
//            }
//            log.info("Reading csv file with path >>" + csv);
//        }
//        return csv;
//    }
//
//
//    /**
//     * get csv rows data
//     *
//     * @param file CSV file object
//     * @return csv rows
//     */
//    public ArrayList<ArrayList<String>> getData(File file) {
//        ArrayList<ArrayList<String>> rows = new ArrayList<ArrayList<String>>();
//        int counter = 0;
//        String line = "";
//        Scanner scan = null;
//        int r = (int) getRowCount(file);
//        int c = (int) getColumnCount(file);
//        //	System.out.println("Number of Rows found: " + r);
//        // System.out.println(c);
//        try (FileReader fRead = new FileReader(file);
//             BufferedReader buffer = new BufferedReader(fRead)) {
//            while ((line = buffer.readLine()) != null) {
//                scan = new Scanner(line);
//                scan.useDelimiter(",");
////                System.out.println(counter+":  " +line);
//                ArrayList<String> tmp = new ArrayList<>();
//                rows.add(tmp);
//                // iterate each cell in row
//                for (String e : Arrays.asList(line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)", -1))) {
//                    if (e.trim().startsWith("\"") && e.trim().endsWith("\""))
//                        e = e.trim().substring(1, e.trim().length() - 1);
////                    System.out.println(" ---"+e);
//                    rows.get(counter).add(e);
//                }
//                counter++;
//            }
//        } catch (IOException e) {
//            log.catching(e);
//        }
//        //  System.out.println(rows.get(3).get(0));
//        return rows;
//    }
//
//    /**
//     * get total number of rows count
//     *
//     * @param file CSV file object
//     * @return rows count
//     */
//    public long getRowCount(File file) {
//        try (FileReader fRead = new FileReader(file);
//             BufferedReader buffer = new BufferedReader(fRead)) {
//            rowCount = buffer.lines().count();
//            // System.out.println("number of Rows is: "+rowCount);
//
//        } catch (IOException e) {
//            log.catching(e);
//        }
//        return rowCount;
//    }
//
//    /**
//     * get column count
//     *
//     * @param file CSV file object
//     * @return columns count
//     */
//    public long getColumnCount(File file) {
//        String line = "";
//        try (FileReader fRead = new FileReader(file);
//             BufferedReader buffer = new BufferedReader(fRead)) {
//
//            while ((line = buffer.readLine()) != null) {
//                StringTokenizer scan = new StringTokenizer(line, ",");
//                // check the maximum col count for each row
//                if (colCount < scan.countTokens())
//                    colCount = scan.countTokens();
//            }
//            //	 System.out.println("columns: " + colCount);
//        } catch (IOException e) {
//            log.catching(e);
//        }
//        return colCount;
//    }
//
//    /**
//     * get rows data from csv file by header and row values
//     *
//     * @param csvFile     csvFile csv file
//     * @param headerValue headerValue header value
//     * @param rowValue    rowValue matched row value for the given header
//     * @return
//     */
//    public List<HashMap<String, String>> getRowsByHeader(File csvFile, String headerValue, String rowValue) {
//        List<HashMap<String, String>> rowMap = new ArrayList<>();
//        ArrayList<ArrayList<String>> body = new CsvReader().getData(csvFile);
//        int keyIndx = body.get(0).indexOf(headerValue);
//        log.info("header '" + headerValue + "' Index is >>" + keyIndx);
//        if (keyIndx == -1) return null;
//        List<ArrayList<String>> rows = body.stream().filter(i -> i.size() > keyIndx && i.get(keyIndx).equals(rowValue)).collect(Collectors.toList());
//        log.info("Getting row which its '" + headerValue + "' equal '" + rowValue + "' >>" + rows);
//        for (List<String> row : rows) {
//            HashMap<String, String> map = new HashMap<>();
//            for (int c = 0; c < body.get(0).size(); c++) {
//                map.put(body.get(0).get(c), row.size() >= c + 1 ? row.get(c) : "");
//            }
//            rowMap.add(map);
//        }
//        return rowMap;
//    }
//
//
//    /**
//     * get a specific row data from csv file by header Name
//     *
//     * @param csvFile     csvFile csv file
//     * @param headerName headerValue header value
//     * @return
//     */
//    public List<String> getValuesByHeader(File csvFile, String headerName) {
//        List<String> headerValues = new ArrayList<>();
//
//        ArrayList<ArrayList<String>> body = new CsvReader().getData(csvFile);
//        int headerIndex = body.get(0).indexOf(headerName);
//        log.info("Header '" + headerName + "' Index is >>" + headerIndex);
//
//        if (headerIndex == -1) return null;
//
//        for (int i = 1; i < body.size(); i++) {
//            ArrayList<String> row = body.get(i);
//            if (row.size() > headerIndex) {
//                headerValues.add(row.get(headerIndex));
//            }
//        }
//
//        return headerValues;
//    }
//
//
//}
