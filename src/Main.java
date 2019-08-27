import java.sql.*;

public class Main {
    public static void main(String args[])
    {
        Connection conn = null;
        Statement stmt= null;
        ResultSet rst= null;
        try{
            //b1 Nạp trình điều kiển
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //b2 Định nghĩa chuỗi kết nối
            String url = "jdbc:sqlserver://PC214\\SQLSERVER;" + "databaseName=QLSanpham_26;";
            //b3 Tạo đối tượng kết nối
            conn = DriverManager.getConnection(url, "sa", "123456");
            //b4 tạo đối tượng thực thi câu lệnh truy vấn và thi hành
            stmt = conn.createStatement();
            System.out.println("--Bang loai san pham---");
            //b5 Thực thi câu lệnh truy vấn
            rst = stmt.executeQuery("select * from LoaiSP");
            //b6 Xử lý kết quả trả về
            while(rst.next())//duyệt các mẫu tin kết quả
            {
                System.out.println(rst.getString("MaLoai") + " - " + rst.getString("TenLoai"));
            }
        }catch(Exception ex){
            System.err.println(ex.toString());
        }
    }
    
}
