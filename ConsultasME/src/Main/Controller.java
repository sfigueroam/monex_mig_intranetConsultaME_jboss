package Main;


import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.beehive.netui.pageflow.Forward;
import org.apache.beehive.netui.pageflow.NotLoggedInException;
import org.apache.beehive.netui.pageflow.PageFlowController;
import org.apache.beehive.netui.pageflow.annotations.Jpf;
import org.apache.beehive.netui.tags.tree.TreeElement;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import cl.tesoreria.utiles.sql.TypesExt;

import org.apache.log4j.Logger;
import cl.tesoreria.monex.utiles.Constantes;
//import cl.tesoreria.seguridad.delegate.SeguridadDelegate;
//import cl.tesoreria.seguridad.profile.ejb.pkgseguridadintranet.PkgSeguridadIntranetException;
//import cl.tesoreria.seguridad.profile.ejb.pkgseguridadintranet.SpSegBuscarTesoUserCaller;
//import cl.tesoreria.seguridad.profile.ejb.pkgseguridadintranet.SpSegBuscarTesoUserResult;




/**
 * 
 */
@Jpf.Controller()
public class Controller extends PageFlowController
{
	
	private TreeElement _simpleTree;
	
	public TreeElement getSimpleTree() {
		return _simpleTree;
	}

	public void setSimpleTree(TreeElement _simpleTree) {
		this._simpleTree = _simpleTree;
	}
	
//    private boolean isAllowed(org.w3c.dom.Node node)
//    {
//    	Set pUser=(Set)getSession().getAttribute("permisosUser");
//        
//        boolean allowed = true;
//        NodeList roleList = node.getChildNodes();
//
//        for (int j = 0; j < roleList.getLength(); j++)
//        {
//            if (roleList.item(j).getNodeName().equalsIgnoreCase("rol-allowed"))
//            {
//                allowed = false;
//                String rolName = roleList.item(j).getAttributes().getNamedItem("name").getNodeValue();
//                
//                //if (getRequest().isUserInRole(rolName))
//                 //   allowed = true;//return true;
//                
//                String[] pgID=rolName.split(",");
//                //Map mapID=(Map)getSession().getAttribute("hashId2");
//                for (int i=0; i < pgID.length; i++)
//                {
//                    //if(mapID.containsKey(pgID[i])) return true;
//                    if (pUser.contains(pgID[i] + "_1"))
//                        return true;
//                    if (pUser.contains(pgID[i] + "_2"))
//                        return true;
//                }
//            }
//        }
//        return allowed;
//    }
	
	private boolean isAllowed(org.w3c.dom.Node node) {
		
		// DESCOMENTAR ES SOLO PARA PRUEBAS
		boolean allowed = true;
		Set pUser = (Set) getSession().getAttribute("permisosUser");
		
		org.w3c.dom.NodeList roleList = node.getChildNodes();
		for (int j = 0; j < roleList.getLength(); j++) {
			if (roleList.item(j).getNodeName().equalsIgnoreCase("rol-allowed")) {
				allowed = false;
				String rolName = roleList.item(j).getAttributes()
						.getNamedItem("name").getNodeValue();
				String[] pgID = rolName.split(",");
				for (int i = 0; i < pgID.length; i++) {
					// if(mapID.containsKey(pgID[i])) return true;
					if (pUser.contains(pgID[i] + "_1"))
						return true;
					if (pUser.contains(pgID[i] + "_2"))
						return true;
				}
			}
		}
		return allowed;
	}

    
//    public TreeElement makeTree(String rootHref, String tocFile, String hrefAttribute, String labelAttribute, boolean nodesInit) throws Exception
//    {
//        InputStream stream = getServlet().getServletContext().getResourceAsStream(tocFile);
//        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//        factory.setNamespaceAware(true);
//        DocumentBuilder parser = factory.newDocumentBuilder();
//        Document document = parser.parse(stream);
//        NodeList nodeList = document.getElementsByTagName("toc-node");
//        String jumpFrame="frameRight";
//        String Address ="";
//        
//        if (!isAllowed(nodeList.item(0)))
//            return null;
//
//        int length = nodeList.getLength();
//        TreeElement[] treeNodeArr = new TreeElement[length];
//        for (int i = 0; i < length; i++)
//        {
//            try
//            {
//                Address = nodeList.item(i).getAttributes().getNamedItem(hrefAttribute).getNodeValue();
//                jumpFrame = "frameRight";
//                /*
//                if (nodeList.item(i).getAttributes().getNamedItem(hrefAttribute).getNodeValue().toString().startsWith("?"))
//                {
//                    jumpFrame = "frameLeft";
//                    Address = "main/treeState.do?netui_treenode=";
//                }
//                */
//                if (nodeList.item(i).getAttributes().getNamedItem(hrefAttribute).getNodeValue().toString().startsWith("../Main/treeState.do"))
//                {
//                    jumpFrame = "frameLeft";
//                }    
//                TreeElement element = new TreeElement(nodeList.item(i).getAttributes().getNamedItem(labelAttribute).getNodeValue(), nodesInit);
//                element.setHref(rootHref + Address);
//                element.setTarget(jumpFrame);
//                treeNodeArr[i] = element;
//            }
//            catch (Exception e)
//            {
//            	TreeElement element = new TreeElement("Error en menu.xml", nodesInit);
//            	element.setHref("blank.jsp");
//            	element.setTarget("frameRight");
//                treeNodeArr[i] = element;
//            }
//        }
//        
//        int[] parentMap = new int[length];
//        for (int i = 0; i < length; i++)
//        {
//            Node parentNode = nodeList.item(i).getParentNode();
//            for (int k = 0; k < i; k++)
//            {
//                if (parentNode == nodeList.item(k))
//                    parentMap[i] = k;
//            }
//        }
//
//        TreeElement rootNode = treeNodeArr[0];
//        //rootNode.setLast(true);
//        rootNode.setExpanded(true);
//        //TreeNode.EXPAND_NODE
//        for (int i = 1; i < length; i++)
//        {
//            if (treeNodeArr[parentMap[i]] != null && isAllowed(nodeList.item(i)))
//                treeNodeArr[parentMap[i]].addChild(treeNodeArr[i]);
//        }
//        //rootNode = reStructure(rootNode, 0, "");
//        //rootNode.setLast(true);
//        return rootNode;
//    }
	
	public TreeElement makeTree(String rootHref, String tocFile, String hrefAttribute, String labelAttribute, boolean nodesInit) throws Exception
    {
        InputStream stream = getServlet().getServletContext().getResourceAsStream(tocFile);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder parser = factory.newDocumentBuilder();
        Document document = parser.parse(stream);
        NodeList nodeList = document.getElementsByTagName("toc-node");
        String jumpFrame="frameRight";
        //String Address ="";
       
        
        if (!isAllowed(nodeList.item(0)))
            return null;

        int length = nodeList.getLength();
        TreeElement[] treeNodeArr = new TreeElement[length];
        for (int i = 0; i < length; i++)
        {
            try
            {
                jumpFrame = "frameRight";
                if (nodeList.item(i).getAttributes().getNamedItem(hrefAttribute).getNodeValue().toString().startsWith("../Main/treeState.do"))
                {
                    jumpFrame = "frameLeft";
                }
                
                treeNodeArr[i] = new TreeElement(//null, 
                		nodeList.item(i).getAttributes().getNamedItem(labelAttribute).getNodeValue(),
                		//null, 
                		//rootHref + nodeList.item(i).getAttributes().getNamedItem(hrefAttribute).getNodeValue(), jumpFrame, 
                		nodesInit);
                treeNodeArr[i].setHref(rootHref + nodeList.item(i).getAttributes().getNamedItem(hrefAttribute).getNodeValue());
                treeNodeArr[i].setTarget(jumpFrame);
            }
            catch (Exception e)
            {
                treeNodeArr[i] = new TreeElement(//null, 
                		"[-label-]", 
                		//null, 
                		//"[-href-]", 
                		//"frameRight", 
                		nodesInit);
                treeNodeArr[i].setHref("[-href-]");
                treeNodeArr[i].setTarget("frameRight");
            }
        }
        
        int[] parentMap = new int[length];
        for (int i = 0; i < length; i++)
        {
            Node parentNode = nodeList.item(i).getParentNode();
            for (int k = 0; k < i; k++)
            {
                if (parentNode == nodeList.item(k))
                    parentMap[i] = k;
            }
        }

        TreeElement rootNode = treeNodeArr[0];
        //rootNode.setLast(true);
        rootNode.setExpanded(true);
        //TreeNode.EXPAND_NODE
        for (int i = 1; i < length; i++)
        {
            if (treeNodeArr[parentMap[i]] != null && isAllowed(nodeList.item(i)))
                treeNodeArr[parentMap[i]].addChild(treeNodeArr[i]);
        }

        return rootNode;
    }

    /**
     * 
    */
    @Jpf.Action(forwards = { 
        @Jpf.Forward(name = "success", path = "main.jsp"), 
        @Jpf.Forward(name = "error", path = "/error.jsp"), 
        @Jpf.Forward(name = "logout", path = "doLogout.do")
    })
    protected Forward begin() throws NotLoggedInException {
    	
        //getSession().setAttribute("sftw_ver","20100630");
    	try
        {
//    		SeguridadDelegate sD = new SeguridadDelegate();
    		String user = getRequest().getUserPrincipal().getName();
    		
    		System.out.println("user: "+user);
        
            //tesorerias
//            List tesorerias = sD.getTesoreriasUser("33", user);
//			HashSet hs = new HashSet(sD.getPermisosUser("33",user).keySet());
    		
    		List tesorerias = getTesoreriasUser(new BigDecimal("33"), user);
    		HashSet hs = new HashSet(getPermisosUser("33",user).keySet());
    		
    		System.out.println("hs.toString(): "+hs.toString());
//    		List tesorerias = new ArrayList();
//    		HashSet hs = new HashSet();
    		
//    		tesorerias.add(arg0)
			getSession().removeAttribute("permisosUser");
			getSession().setAttribute("permisosUser", hs);
			getSession().setAttribute("globalTesorerias", tesorerias);
			getSession().setAttribute("errorMessage", null);
			
            //TreeNode rootNode = makeTree("", "resources/menu/menu.xml", "url", "label", false);
            //if (rootNode == null)
            //_simpleTree = makeTree("../", "/resources/menu/menu.xml", "url", "label", false);
			_simpleTree = makeTree("", "/resources/menu/menu.xml", "url", "label", false);
            if (_simpleTree==null)
            {
                getSession().setAttribute("errorMessage", "Usuario no autorizado");
                return new Forward("logout");
            }
            //getSession().setAttribute("tree", rootNode);
            getSession().setAttribute("tree", _simpleTree);
            getSession().setAttribute("nestedFromMain", "false");
            return new Forward("success");
        }catch (Exception e){
            e.printStackTrace();
            getRequest().setAttribute("errorMessage", e.getMessage());
            return new Forward("error");
        }
    }

    /**
     * 
     */
    @Jpf.Action(forwards = { 
        @Jpf.Forward(name = "success",
                     path = "/logout.jsp")
    })
    protected Forward doLogout()
    {
        //logout(true);
    	//Eliminar Cookie de Autenticacion
    	//weblogic.servlet.security.ServletAuthentication.logout(this.getRequest());
    	if (getRequest().getSession(false) != null)
        {
            getRequest().getSession(false).invalidate(); 
            //TODO ESTA LINEA SE COMENTO EL CODIGO SE DEBE VERIFICAR 01/08/2019 ccastrov@redhat.com
//            weblogic.servlet.security.ServletAuthentication.logout(getRequest());
        }    
    	getSession().setAttribute("errorMessage", "Ud. ha salido del Sistema");
        return new Forward("success");
    }

    /**
     * 
     */
    @Jpf.Action(loginRequired = true, 
                catches = { 
                    @Jpf.Catch(type = org.apache.beehive.netui.pageflow.NotLoggedInException.class,
                               path = "/login.jsp") }, 
                forwards = { 
    				@Jpf.Forward(name = "tree", path = "tree.jsp") })
    protected Forward treeState() throws Exception
    {
    	
    	
    	System.out.println("dentro de tree1");
    	
    	if (_simpleTree==null){
    		//System.out.println("==>Menu Nulo!!!");
    		_simpleTree = (TreeElement) getSession().getAttribute("tree");
    	}
    	System.out.println("dentro de tree2");
    	return new Forward("tree");
    	/*
        TreeNode rootNode = getTree();
        if (rootNode == null)
        {
            return new Forward("logout");
        }
        String nodeSelected = null;
        String nodeExpanded = null;

        nodeSelected = getRequest().getParameter(TreeNode.SELECTED_NODE);
        nodeExpanded = getRequest().getParameter(TreeNode.EXPAND_NODE);
        if (nodeExpanded != null)
        {
            TreeNode node = rootNode.findNode(nodeExpanded);

            if (node != null)
            {
                node.setExpanded(!node.isExpanded());
            }
            return new Forward("tree");
        }
        return new Forward(nodeSelected);
        */
    	
    }

    /*
    public TreeNode getTree() throws Exception {
        TreeNode rootNode = (TreeNode) getSession().getAttribute("tree");

        if (rootNode == null) {
            rootNode = makeTree("", "resources/menu/menu.xml", "url", "label",
                    false);
            getSession().setAttribute("tree", rootNode);
        }
        return rootNode;
    }
    */

//	@Jpf.Action(
//		forwards = { 
//			@Jpf.Forward(name = "failure", path = "/login.jsp")
//		}
//	)
//    protected Forward loginExpired() {
//        getSession().setAttribute("errorMessage", "La sesi�n ha expirado");
//        return new Forward("failure");
//    }

    
	public HashMap getPermisosUser(String idApp, String userName) throws Exception {
//		new HashMap();
		return this.getValues(idApp, userName);
	}
	
	
	private HashMap getValues(String idApp, String userName) throws Exception {
		String strId = null;
		HashMap hashId = null;
//		SeguridadDelegate segDelegate = null;
		if (idApp != null && !idApp.equals("") && userName != null && !userName.equals("")) {
//			new SeguridadDelegate();
			
//			strId = this.locator.getSegFacadeIntranetEJB3().getPermisosUser(new BigDecimal(idApp), userName);
			
			strId = spSegBuscarId(new BigDecimal(idApp), userName);
			
			System.out.println("strId: "+strId);
			
//			SpSegBuscarIdResult segBuscarId=pkgSeguridadIntranetEJB3Local.spSegBuscarId(appId,user);
//            strId = segBuscarId.getOStrid();
            
			
			
			String[] arrayG = strId.split("G");
			hashId = new HashMap();

			for (int i = 0; i < arrayG.length; ++i) {
				String[] array1 = arrayG[i].split(";");

				for (int j = 0; j < array1.length; ++j) {
					hashId.put(array1[j], array1[j]);
				}
			}

			return hashId;
		} else {
			return null;
		}
	}
	
	
	
	
	
	//Permisos User
//	@Override
	public String spSegBuscarId(BigDecimal iAppId, String iUser) throws SQLException
			 {
		
		Connection conn = null;
		CallableStatement call = null;
        try
        {
        	
        	System.out.println("iAppId: "+iAppId);
            System.out.println("iUser: "+iUser);

            Constantes.cargarArchivoME();
            logger.info("Seguimiento ------ JNDI_DATASOURCE_BEA=" + Constantes.JNDI_DATASOURCE_BEA);            

        	Context ctx = new InitialContext();
    		DataSource dataSource = (DataSource)ctx.lookup(Constantes.JNDI_DATASOURCE_BEA);
    		conn = dataSource.getConnection();
    		
    		System.out.println("conn: "+conn);
    		
            ArrayList resultSets = new ArrayList();
            call = conn.prepareCall("{call SEGURIDAD2.PKG_SEGURIDAD_INTRANET.SP_SEG_BUSCAR_ID(?,?,?,?)}");
            
            call.registerOutParameter(1, Types.NUMERIC);
            call.registerOutParameter(2, Types.VARCHAR);
            call.setBigDecimal(3, iAppId);
            call.setString(4, iUser);
            call.execute();
            
            return call.getString(2);
//            executeCall(call, resultSets);
//            result.setOCodError(call.getBigDecimal(1));
//            result.setOStrid(call.getString(2));
        }catch(Exception e) {
        	e.printStackTrace();
        }finally {
        	conn.close();
        	call.close();
        	
        }
        
        return null;
        
//		try {
//			return SpSegBuscarIdCaller.execute(dataSource, iAppId, iUser);
//		} catch (java.sql.SQLException ex) {
//			throw new PkgSeguridadIntranetException(
//					"PKG_SEGURIDAD_INTRANET.SP_SEG_BUSCAR_ID", ex);
//		}
	}
	
	
//	getTesoreriasUser
	
	
	
	
	public List getTesoreriasUser(BigDecimal appId, String user) {
		
		List resultSets = new ArrayList();
		
	        try
	        {
	        	
	        	ResultSet rs = null;
                
                Constantes.cargarArchivoME();
                logger.info("Seguimiento ------ JNDI_DATASOURCE_BEA=" + Constantes.JNDI_DATASOURCE_BEA);            

	        	Context ctx = new InitialContext();
	    		DataSource dataSource = (DataSource)ctx.lookup(Constantes.JNDI_DATASOURCE_BEA);
	    		Connection conn = dataSource.getConnection();
	    		
	            
	            String dbmsURL = conn.getMetaData().getURL();
	            if (dbmsURL.startsWith("jdbc:oracle:thin"))
	            {
	                CallableStatement call = conn.prepareCall("{call SEGURIDAD2.PKG_SEGURIDAD_INTRANET.SP_SEG_BUSCAR_TESO_USER(?,?,?,?)}");
	                try
	                {
	                    call.registerOutParameter(1, Types.NUMERIC);
	                    call.registerOutParameter(2, TypesExt.CURSOR);
	                    call.setString(3, user);
	                    call.setBigDecimal(4, appId);
	                    
	                    call.execute();
	                    
	                    rs = (ResultSet) call.getObject(2);
	                    while (rs.next()) {
	                        String[] array = new String[]{rs.getBigDecimal(1).toString(),
                                    rs.getString(2),
                                    rs.getBigDecimal(3).toString(),
                                    rs.getString(4),
                                    rs.getString(5),
                                    rs.getBigDecimal(6).toString(),
                                    rs.getBigDecimal(7).toString(),
                                    rs.getString(8),
                                    rs.getBigDecimal(9).toString(),
                                    rs.getString(10)};

	                        resultSets.add(array);
	                    } // End while
	                    
	                    
	                    
//	                    executeCall(call, resultSets);
//	                    result.setOCodError(call.getBigDecimal(1));
//	                    addResultSet((ResultSet) call.getObject(2), resultSets);
	                }
	                finally
	                {
	                	rs.close();
	                    call.close();
	                    conn.close();
	                }
	            }
//	            else
//	            {
//	                CallableStatement call = conn.prepareCall("{call PKG_SEGURIDAD_INTRANET.SP_SEG_BUSCAR_TESO_USER(?,?,?)}");
//	                try
//	                {
//	                    call.registerOutParameter(1, Types.NUMERIC);
//	                    call.setString(2, iUser);
//	                    call.setBigDecimal(3, iAppId);
//	                    executeCall(call, resultSets);
//	                    result.setOCodError(call.getBigDecimal(1));
//	                }
//	                finally
//	                {
//	                    call.close();
//	                }
//	            }
//	            result.setRowSets(toRowSets(resultSets));
	        }catch(Exception e) {
	        	e.printStackTrace();
	        }
	      
	        
	        
	        
//            if (segBuscarTeso.getOCodError().equals(new BigDecimal(0)))
//            {
//               
//                if (segBuscarTeso.getRowSetCount() > 0)
//                {
//                    rs = segBuscarTeso.getRowSet(0);
//                }
//                lista = new ArrayList();
//                while (rs.next())
//                {
//                    
//                    String[] array = new String[]{rs.getBigDecimal(1).toString(),
//                                                        rs.getString(2),
//                                                        rs.getBigDecimal(3).toString(),
//                                                        rs.getString(4),
//                                                        rs.getString(5),
//                                                        rs.getBigDecimal(6).toString(),
//                                                        rs.getBigDecimal(7).toString(),
//                                                        rs.getString(8),
//                                                        rs.getBigDecimal(9).toString(),
//                                                        rs.getString(10)};
//                  
//                    lista.add(array);
//                }   
//                        
//                  
//                sw = true; 
//            } 
            
            
            
		
//		try {
//			return SpSegBuscarTesoUserCaller.execute(dataSource, iUser, iAppId);
//		} catch (java.sql.SQLException ex) {
//			throw new PkgSeguridadIntranetException(
//					"PKG_SEGURIDAD_INTRANET.SP_SEG_BUSCAR_TESO_USER", ex);
//		}
		
		
		return resultSets;
	}
	
	
	
	
}
