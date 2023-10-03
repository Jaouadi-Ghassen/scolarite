package Web;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import dao.GestionCourseImp;
import dao.GestionGroupe;
import dao.GestionStudentImp;
import dao.IGestionCourse;
import dao.IGestionGroup;
import dao.IGestionStudent;
import dao.entities.Course;
import dao.entities.Groupe;
import dao.entities.Student;

/**
 * Servlet implementation class Controlleur
 */
@MultipartConfig
@WebServlet("/Controlleur")
public class Controlleur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controlleur() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
    IGestionStudent gestion ;
    IGestionGroup gestionGr;
    IGestionCourse gestioncr;

	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	   

		gestion = new GestionStudentImp() ;
		gestionGr = new GestionGroupe();
		gestioncr = new GestionCourseImp();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    HttpSession session = request.getSession(false);
	    int page = 1;
	    int recordsPerPage = 4;
	    if(request.getParameter("page") != null)
	        page = Integer.parseInt(request.getParameter("page"));
	    int offset = (page-1) * recordsPerPage;

	    if(session != null) {
	        String action = request.getParameter("action");
	        if(action == null) {
	            int totalStudents = gestion.getStudentCount();
	            int totalPages = (int) Math.ceil((double)totalStudents/recordsPerPage);
	            List<Student>liste = gestion.getAllStudent(offset, recordsPerPage);
	            request.setAttribute("listeStudent", liste);
	            request.setAttribute("totalPages", totalPages);
	            request.setAttribute("currentPage", page);
	            request.getRequestDispatcher("Vue.jsp").forward(request, response);    
	        }

				else if(action.equalsIgnoreCase("research")) {
				String mc= request.getParameter("mc");
				request.setAttribute("listeStudent", gestion.getStudentByMc(mc));
				request.getRequestDispatcher("Vue.jsp").forward(request, response);		
			}
			
			else if(action.equalsIgnoreCase("edit") ) {
				int id = Integer.parseInt(request.getParameter("id"));
				  Student s = gestion.getStudentById(id);
				  request.setAttribute("student", s);
				  List<Groupe>listgr=gestionGr.getAllGroupes();
				  request.setAttribute("listgr", listgr);
				  request.getRequestDispatcher("EditStudent.jsp").forward(request, response);
			  }	
				
			else if (action.equalsIgnoreCase("delete")){
				  int id = Integer.parseInt(request.getParameter("id"));
				  Student s = gestion.getStudentById(id);
				  gestion.deleteStudent(s);
				  List<Student>liste=gestion.getAllStudent();
				  request.setAttribute("listeStudent", liste);
				  request.getRequestDispatcher("Vue.jsp").forward(request, response);  
			  }
				
				else if (action.equalsIgnoreCase("addstd")) {
					List<Groupe>listgr=gestionGr.getAllGroupes();
					request.setAttribute("listgr", listgr);
				  request.getRequestDispatcher("AjoutStudent.jsp").forward(request, response);
			  	}
				
				else if (action.equalsIgnoreCase("Ajoutstd") && request.getMethod().equalsIgnoreCase("post")) {
					  String username = request.getParameter("username");
					  String email= request.getParameter("email");
					  String password= request.getParameter("password");
					  String datens= request.getParameter("datens");
					  String adresse= request.getParameter("adresse");
					  String phone= request.getParameter("phone");

					  int groupid = Integer.parseInt(request.getParameter("gid"));
					  Groupe gp = gestionGr.getGroupe(groupid);
					  
					  Part filePart = request.getPart("photo");
					  String file = filePart.getSubmittedFileName();
					  InputStream inputStream = null;
					  if(filePart != null) {
						  long fileSize = filePart.getSize();
						  String fileContent = filePart.getContentType();
						  inputStream=filePart.getInputStream();
					  }

					  Student s = new Student(username,email,password,phone,datens,adresse,gp,file);
					  gestion.addStudent(s);
					  List<Student>liste=gestion.getAllStudent();
					  request.setAttribute("listeStudent", liste);
					  request.getRequestDispatcher("Vue.jsp").forward(request, response);
				}
				else if (action.equalsIgnoreCase("deletegr")){
					  int id = Integer.parseInt(request.getParameter("id"));
					  Groupe g = gestionGr.getGroupe(id);
					  gestionGr.DeletGr(g);
					  List<Groupe>listgr=gestionGr.getAllGroupes();
					  request.setAttribute("listgr", listgr);
					  request.getRequestDispatcher("addGroup.jsp").forward(request, response);  
				  }
				
				else if(action.equalsIgnoreCase("DetaiStd") ) {
					int id = Integer.parseInt(request.getParameter("id"));
					  Student s = gestion.getStudentById(id);
					  request.setAttribute("student", s);
					  request.getRequestDispatcher("StudentDetail.jsp").forward(request, response);
				  }
				else if(action.equalsIgnoreCase("addgrFrom") ) {
						List<Groupe>listgr=gestionGr.getAllGroupes();
						request.setAttribute("listgr", listgr);
					  request.getRequestDispatcher("addGroup.jsp").forward(request, response);
				  }	
				else if(action.equalsIgnoreCase("addGroup")&& request.getMethod().equalsIgnoreCase("post")) {
					 String nom = request.getParameter("groupe");
					 Groupe g = new Groupe(nom);
					 gestionGr.AddGroup(g);
					List<Groupe>listgr=gestionGr.getAllGroupes();
					request.setAttribute("listgr", listgr);
				  request.getRequestDispatcher("addGroup.jsp").forward(request, response);
			  }	
				else if (action.equalsIgnoreCase("EditStudent")) {
					
					  String username = request.getParameter("username");
					  String email= request.getParameter("email");
					  String password= request.getParameter("password");
					  String datens= request.getParameter("datens");
					  String adresse= request.getParameter("adresse");
					  String phone= request.getParameter("phone");
					  int groupid = Integer.parseInt(request.getParameter("gid"));
					  Groupe gp = gestionGr.getGroupe(groupid);
					  int id = Integer.parseInt(request.getParameter("id"));
					  Student s = new Student(id,username,email,password,phone,datens,adresse,gp);
					  gestion.updateStudent(s);
					  List<Student>liste=gestion.getAllStudent();
					  request.setAttribute("listeStudent", liste);
					  request.getRequestDispatcher("Vue.jsp").forward(request, response);
				}	
				else if(action.equalsIgnoreCase("addcrFrom")) {
				  List<Course>listCourse=gestioncr.getAllCourse();
				  request.setAttribute("listCourse", listCourse);
				  request.getRequestDispatcher("AddMatiere.jsp").forward(request, response);
			  }	
				else if(action.equalsIgnoreCase("addMatiere")&& request.getMethod().equalsIgnoreCase("post")) {
					 String nom = request.getParameter("course");
					 Course c = new Course(nom);
					 gestioncr.addCourse(c);
					 List<Course>listCourse=gestioncr.getAllCourse();
					  request.setAttribute("listCourse", listCourse);
					  request.getRequestDispatcher("AddMatiere.jsp").forward(request, response);
			  }	
				else if (action.equalsIgnoreCase("deleteCr")){
				  int id = Integer.parseInt(request.getParameter("id"));
				  Course c = gestioncr.getCourseById(id);
				  gestioncr.deleteCourse(c);
				  List<Course>listCourse=gestioncr.getAllCourse();
				  request.setAttribute("listCourse", listCourse);
				  request.getRequestDispatcher("AddMatiere.jsp").forward(request, response);
			  }
	        
	        
				
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	


}
