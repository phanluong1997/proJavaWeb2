/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import dao.DAOloaigiay;
import dto.giay;
import dto.loaigiay;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
public class LoaiGiayDELServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<html>\n" +
"    <head>\n" +
"        <title>Sneakers&reg; | Giày thể thao Adidas - Chất lượng vàng</title>\n" +
"        <meta charset=\"UTF-8\">\n" +
"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"        <link href=\"css/style.css\" rel=\"stylesheet\" type=\"text/css\"/>\n" +
"        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css\">\n" +
"    </head>    \n" +
"    <body>\n" +
"       <header><h1>TRANG QUẢN LÍ BÁN GIÀY</h1></header>\n" +
"       <nav>\n" +
"           <button>\n" +
"              <a href=\"http://localhost:8084/ThiHocKiWeb2/\">Trang Chủ</a>\n" +
"           </button>\n" +
"           <button>\n" +
"                <a href=\"http://localhost:8084/ThiHocKiWeb2/GiayListServlet\" data-toggle=\"dropdown\">Danh Mục<span class= \"caret\"></span></a>\n" +
"           </button>\n" +
"           <button>\n" +
"               <a href=\"https://www.facebook.com/phan.luong.3597\" data-toggle=\"dropdown\">Liên Hệ Facebook<span class=\"caret\"></span></a>                    \n" +
"           </button>\n" +
"           <button class=\"dangnhap\">\n" +
"               <a href=\"#\">Đăng Nhập</a>\n" +
"           </button>\n" +
"           <button class=\"dangnhap\">\n" +
"               <a href=\"#\">Đăng ký</a>\n" +
"           </button>\n" +
"       </nav>\n" +
"        <main>\n" +
"            <aside> \n" +
"                <h5>Thông tin chi tiết</h5>\n" +
"                <ul>\n" +
"                    <li><a href=\"http://localhost:8084/ThiHocKiWeb2/LoaiGiayListServlet\">Danh sách Giày</a></li>\n" +
"                    <li><a href=\"http://localhost:8084/ThiHocKiWeb2/GiayListServlet\">Danh Mục Giày</a></li>\n" +
"                    <li><a href=\"#\">Giới thiệu</a></li>\n" +
"                </ul>\n" +
"            </aside>\n" +
"            <section>");
            out.println("<h2>Kết quả xóa</h2>");
            int id = Integer.parseInt(request.getParameter("id"));
           // out.println(""+id);
            DAOloaigiay dao = new DAOloaigiay();
            loaigiay s = dao.readById(id);
            
            
            out.println("<form action='LoaiGiayDel2Servlet' method='post'>");
            
            out.println("<table>");
            
            out.println("<tr>");
            out.println("<td>IDLoại giày:</td>");
            out.println("<td>" + s.getIdloaigiay()+ "</td>");
            out.println("</tr>");
            
            out.println("<tr>");
            out.println("<td><label for='tenloai'>Tên Loại</label></td>");
            out.println("<td><input type='text' name='tenloai' id='tenloai' value='" +
                    s.getTenloai()+ "'></td>");
            out.println("</tr>");
            
            out.println("<tr>");
            out.println("<td colspan='2'><button type='submit' name='idloaigiay' value='" 
                    + s.getIdloaigiay()+ "'>Lưu</button></td>");
            out.println("</tr>");
            out.println("</table>");
            out.println("</form>");
            out.println("</section>\n" +
"        </main>\n" +
"      <footer>\n" +
"          <div class=\"row\">   \n" +
"              <div class=\"col-md-4\">\n" +
"        <div class=\"about\">\n" +
"            <h2>About Us</h2>\n" +
"            <p id=\"phai\">CHUYÊN CUNG CẤP CÁC LOẠI GIÀY ADIDAS TẠI HUẾ</p>\n" +
"        </div>\n" +
"              </div>\n" +
"              <div class=\"col-md-4\">\n" +
"        <div class=\"contact\">\n" +
"            <h2>Contacts</h2>\n" +
"            <p><span>Email:</span>phanluong19972015@gmail.com</p>\n" +
"            <p><span>Tel:</span>0349190665</p>\n" +
"            <p><span>Facebook:</span><a href=\"#\">phan.luong.3597</a>\n" +
"        </div>\n" +
"              </div>\n" +
"              <div class=\"col-md-2\" >  \n" +
"        <div class=\"link\">\n" +
"            \n" +
"            <p> Copyrights &copy; 2019 PhanLuong1997</p>\n" +
"        </div>\n" +
"          </div>     \n" +
"          </div>\n" +
"        </footer>\n" +
"    </body>\n" +
"</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
