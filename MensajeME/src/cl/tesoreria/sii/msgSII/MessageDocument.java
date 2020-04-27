/*
 * An XML document type.
 * Localname: Message
 * Namespace: http://tesoreria.cl/sii/MsgSII.xsd
 * Java type: cl.tesoreria.sii.msgSII.MessageDocument
 *
 * Automatically generated - do not modify.
 */
package cl.tesoreria.sii.msgSII;


/**
 * A document containing one Message(@http://tesoreria.cl/sii/MsgSII.xsd) element.
 *
 * This is a complex type.
 */
public interface MessageDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(MessageDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.MensajeMETypeSystem").resolveHandle("messagebf2bdoctype");
    
    /**
     * Gets the "Message" element
     */
    cl.tesoreria.sii.msgSII.MessageDocument.Message getMessage();
    
    /**
     * Sets the "Message" element
     */
    void setMessage(cl.tesoreria.sii.msgSII.MessageDocument.Message message);
    
    /**
     * Appends and returns a new empty "Message" element
     */
    cl.tesoreria.sii.msgSII.MessageDocument.Message addNewMessage();
    
    /**
     * An XML Message(@http://tesoreria.cl/sii/MsgSII.xsd).
     *
     * This is a complex type.
     */
    public interface Message extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(Message.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.MensajeMETypeSystem").resolveHandle("messagef5b8elemtype");
        
        /**
         * Gets the "MessageId" element
         */
        cl.tesoreria.sii.msgSII.MessageDocument.Message.MessageId getMessageId();
        
        /**
         * Sets the "MessageId" element
         */
        void setMessageId(cl.tesoreria.sii.msgSII.MessageDocument.Message.MessageId messageId);
        
        /**
         * Appends and returns a new empty "MessageId" element
         */
        cl.tesoreria.sii.msgSII.MessageDocument.Message.MessageId addNewMessageId();
        
        /**
         * Gets the "Detalle" element
         */
        cl.tesoreria.sii.msgSII.MessageDocument.Message.Detalle getDetalle();
        
        /**
         * Sets the "Detalle" element
         */
        void setDetalle(cl.tesoreria.sii.msgSII.MessageDocument.Message.Detalle detalle);
        
        /**
         * Appends and returns a new empty "Detalle" element
         */
        cl.tesoreria.sii.msgSII.MessageDocument.Message.Detalle addNewDetalle();
        
        /**
         * Gets the "Resultado" element
         */
        cl.tesoreria.sii.msgSII.MessageDocument.Message.Resultado getResultado();
        
        /**
         * Sets the "Resultado" element
         */
        void setResultado(cl.tesoreria.sii.msgSII.MessageDocument.Message.Resultado resultado);
        
        /**
         * Appends and returns a new empty "Resultado" element
         */
        cl.tesoreria.sii.msgSII.MessageDocument.Message.Resultado addNewResultado();
        
        /**
         * Gets the "Errores" element
         */
        cl.tesoreria.sii.msgSII.MessageDocument.Message.Errores getErrores();
        
        /**
         * True if has "Errores" element
         */
        boolean isSetErrores();
        
        /**
         * Sets the "Errores" element
         */
        void setErrores(cl.tesoreria.sii.msgSII.MessageDocument.Message.Errores errores);
        
        /**
         * Appends and returns a new empty "Errores" element
         */
        cl.tesoreria.sii.msgSII.MessageDocument.Message.Errores addNewErrores();
        
        /**
         * Unsets the "Errores" element
         */
        void unsetErrores();
        
        /**
         * An XML MessageId(@http://tesoreria.cl/sii/MsgSII.xsd).
         *
         * This is a complex type.
         */
        public interface MessageId extends org.apache.xmlbeans.XmlObject
        {
            public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
                org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(MessageId.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.MensajeMETypeSystem").resolveHandle("messageida02aelemtype");
            
            /**
             * Gets the "Code" element
             */
            java.lang.String getCode();
            
            /**
             * Gets (as xml) the "Code" element
             */
            org.apache.xmlbeans.XmlString xgetCode();
            
            /**
             * Sets the "Code" element
             */
            void setCode(java.lang.String code);
            
            /**
             * Sets (as xml) the "Code" element
             */
            void xsetCode(org.apache.xmlbeans.XmlString code);
            
            /**
             * Gets the "MsgDesc" element
             */
            java.lang.String getMsgDesc();
            
            /**
             * Gets (as xml) the "MsgDesc" element
             */
            org.apache.xmlbeans.XmlString xgetMsgDesc();
            
            /**
             * Sets the "MsgDesc" element
             */
            void setMsgDesc(java.lang.String msgDesc);
            
            /**
             * Sets (as xml) the "MsgDesc" element
             */
            void xsetMsgDesc(org.apache.xmlbeans.XmlString msgDesc);
            
            /**
             * Gets the "Version" element
             */
            long getVersion();
            
            /**
             * Gets (as xml) the "Version" element
             */
            org.apache.xmlbeans.XmlLong xgetVersion();
            
            /**
             * Sets the "Version" element
             */
            void setVersion(long version);
            
            /**
             * Sets (as xml) the "Version" element
             */
            void xsetVersion(org.apache.xmlbeans.XmlLong version);
            
            /**
             * Gets the "FromAddress" element
             */
            java.lang.String getFromAddress();
            
            /**
             * Gets (as xml) the "FromAddress" element
             */
            org.apache.xmlbeans.XmlString xgetFromAddress();
            
            /**
             * Sets the "FromAddress" element
             */
            void setFromAddress(java.lang.String fromAddress);
            
            /**
             * Sets (as xml) the "FromAddress" element
             */
            void xsetFromAddress(org.apache.xmlbeans.XmlString fromAddress);
            
            /**
             * Gets the "ToAddress" element
             */
            java.lang.String getToAddress();
            
            /**
             * Gets (as xml) the "ToAddress" element
             */
            org.apache.xmlbeans.XmlString xgetToAddress();
            
            /**
             * Sets the "ToAddress" element
             */
            void setToAddress(java.lang.String toAddress);
            
            /**
             * Sets (as xml) the "ToAddress" element
             */
            void xsetToAddress(org.apache.xmlbeans.XmlString toAddress);
            
            /**
             * Gets the "RefAddress" element
             */
            java.math.BigDecimal getRefAddress();
            
            /**
             * Gets (as xml) the "RefAddress" element
             */
            org.apache.xmlbeans.XmlDecimal xgetRefAddress();
            
            /**
             * Sets the "RefAddress" element
             */
            void setRefAddress(java.math.BigDecimal refAddress);
            
            /**
             * Sets (as xml) the "RefAddress" element
             */
            void xsetRefAddress(org.apache.xmlbeans.XmlDecimal refAddress);
            
            /**
             * Gets the "Validado" element
             */
            java.lang.String getValidado();
            
            /**
             * Gets (as xml) the "Validado" element
             */
            org.apache.xmlbeans.XmlString xgetValidado();
            
            /**
             * Sets the "Validado" element
             */
            void setValidado(java.lang.String validado);
            
            /**
             * Sets (as xml) the "Validado" element
             */
            void xsetValidado(org.apache.xmlbeans.XmlString validado);
            
            /**
             * Gets the "Number" element
             */
            java.math.BigDecimal getNumber();
            
            /**
             * Gets (as xml) the "Number" element
             */
            org.apache.xmlbeans.XmlDecimal xgetNumber();
            
            /**
             * Sets the "Number" element
             */
            void setNumber(java.math.BigDecimal number);
            
            /**
             * Sets (as xml) the "Number" element
             */
            void xsetNumber(org.apache.xmlbeans.XmlDecimal number);
            
            /**
             * A factory class with static methods for creating instances
             * of this type.
             */
            
            public static final class Factory
            {
                public static cl.tesoreria.sii.msgSII.MessageDocument.Message.MessageId newInstance() {
                  return (cl.tesoreria.sii.msgSII.MessageDocument.Message.MessageId) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
                
                public static cl.tesoreria.sii.msgSII.MessageDocument.Message.MessageId newInstance(org.apache.xmlbeans.XmlOptions options) {
                  return (cl.tesoreria.sii.msgSII.MessageDocument.Message.MessageId) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
                
                private Factory() { } // No instance of this class allowed
            }
        }
        
        /**
         * An XML Detalle(@http://tesoreria.cl/sii/MsgSII.xsd).
         *
         * This is a complex type.
         */
        public interface Detalle extends org.apache.xmlbeans.XmlObject
        {
            public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
                org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(Detalle.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.MensajeMETypeSystem").resolveHandle("detallec495elemtype");
            
            /**
             * Gets the "TipoRegistro" element
             */
            java.math.BigDecimal getTipoRegistro();
            
            /**
             * Gets (as xml) the "TipoRegistro" element
             */
            org.apache.xmlbeans.XmlDecimal xgetTipoRegistro();
            
            /**
             * Sets the "TipoRegistro" element
             */
            void setTipoRegistro(java.math.BigDecimal tipoRegistro);
            
            /**
             * Sets (as xml) the "TipoRegistro" element
             */
            void xsetTipoRegistro(org.apache.xmlbeans.XmlDecimal tipoRegistro);
            
            /**
             * Gets the "RutIra" element
             */
            java.math.BigDecimal getRutIra();
            
            /**
             * Gets (as xml) the "RutIra" element
             */
            org.apache.xmlbeans.XmlDecimal xgetRutIra();
            
            /**
             * Sets the "RutIra" element
             */
            void setRutIra(java.math.BigDecimal rutIra);
            
            /**
             * Sets (as xml) the "RutIra" element
             */
            void xsetRutIra(org.apache.xmlbeans.XmlDecimal rutIra);
            
            /**
             * Gets the "DvIra" element
             */
            java.lang.String getDvIra();
            
            /**
             * Gets (as xml) the "DvIra" element
             */
            org.apache.xmlbeans.XmlString xgetDvIra();
            
            /**
             * Sets the "DvIra" element
             */
            void setDvIra(java.lang.String dvIra);
            
            /**
             * Sets (as xml) the "DvIra" element
             */
            void xsetDvIra(org.apache.xmlbeans.XmlString dvIra);
            
            /**
             * Gets the "FolioF01" element
             */
            java.math.BigDecimal getFolioF01();
            
            /**
             * Gets (as xml) the "FolioF01" element
             */
            org.apache.xmlbeans.XmlDecimal xgetFolioF01();
            
            /**
             * Sets the "FolioF01" element
             */
            void setFolioF01(java.math.BigDecimal folioF01);
            
            /**
             * Sets (as xml) the "FolioF01" element
             */
            void xsetFolioF01(org.apache.xmlbeans.XmlDecimal folioF01);
            
            /**
             * Gets the "FechaRecepcion" element
             */
            java.math.BigDecimal getFechaRecepcion();
            
            /**
             * Gets (as xml) the "FechaRecepcion" element
             */
            org.apache.xmlbeans.XmlDecimal xgetFechaRecepcion();
            
            /**
             * Sets the "FechaRecepcion" element
             */
            void setFechaRecepcion(java.math.BigDecimal fechaRecepcion);
            
            /**
             * Sets (as xml) the "FechaRecepcion" element
             */
            void xsetFechaRecepcion(org.apache.xmlbeans.XmlDecimal fechaRecepcion);
            
            /**
             * Gets the "RutContr" element
             */
            java.math.BigDecimal getRutContr();
            
            /**
             * Gets (as xml) the "RutContr" element
             */
            org.apache.xmlbeans.XmlDecimal xgetRutContr();
            
            /**
             * Sets the "RutContr" element
             */
            void setRutContr(java.math.BigDecimal rutContr);
            
            /**
             * Sets (as xml) the "RutContr" element
             */
            void xsetRutContr(org.apache.xmlbeans.XmlDecimal rutContr);
            
            /**
             * Gets the "DvContr" element
             */
            java.lang.String getDvContr();
            
            /**
             * Gets (as xml) the "DvContr" element
             */
            org.apache.xmlbeans.XmlString xgetDvContr();
            
            /**
             * Sets the "DvContr" element
             */
            void setDvContr(java.lang.String dvContr);
            
            /**
             * Sets (as xml) the "DvContr" element
             */
            void xsetDvContr(org.apache.xmlbeans.XmlString dvContr);
            
            /**
             * Gets the "Formulario" element
             */
            java.math.BigDecimal getFormulario();
            
            /**
             * Gets (as xml) the "Formulario" element
             */
            org.apache.xmlbeans.XmlDecimal xgetFormulario();
            
            /**
             * Sets the "Formulario" element
             */
            void setFormulario(java.math.BigDecimal formulario);
            
            /**
             * Sets (as xml) the "Formulario" element
             */
            void xsetFormulario(org.apache.xmlbeans.XmlDecimal formulario);
            
            /**
             * Gets the "Folio" element
             */
            java.math.BigDecimal getFolio();
            
            /**
             * Gets (as xml) the "Folio" element
             */
            org.apache.xmlbeans.XmlDecimal xgetFolio();
            
            /**
             * Sets the "Folio" element
             */
            void setFolio(java.math.BigDecimal folio);
            
            /**
             * Sets (as xml) the "Folio" element
             */
            void xsetFolio(org.apache.xmlbeans.XmlDecimal folio);
            
            /**
             * Gets the "Periodo" element
             */
            java.math.BigDecimal getPeriodo();
            
            /**
             * Gets (as xml) the "Periodo" element
             */
            org.apache.xmlbeans.XmlDecimal xgetPeriodo();
            
            /**
             * Sets the "Periodo" element
             */
            void setPeriodo(java.math.BigDecimal periodo);
            
            /**
             * Sets (as xml) the "Periodo" element
             */
            void xsetPeriodo(org.apache.xmlbeans.XmlDecimal periodo);
            
            /**
             * A factory class with static methods for creating instances
             * of this type.
             */
            
            public static final class Factory
            {
                public static cl.tesoreria.sii.msgSII.MessageDocument.Message.Detalle newInstance() {
                  return (cl.tesoreria.sii.msgSII.MessageDocument.Message.Detalle) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
                
                public static cl.tesoreria.sii.msgSII.MessageDocument.Message.Detalle newInstance(org.apache.xmlbeans.XmlOptions options) {
                  return (cl.tesoreria.sii.msgSII.MessageDocument.Message.Detalle) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
                
                private Factory() { } // No instance of this class allowed
            }
        }
        
        /**
         * An XML Resultado(@http://tesoreria.cl/sii/MsgSII.xsd).
         *
         * This is a complex type.
         */
        public interface Resultado extends org.apache.xmlbeans.XmlObject
        {
            public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
                org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(Resultado.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.MensajeMETypeSystem").resolveHandle("resultado3d9delemtype");
            
            /**
             * Gets the "Aprobacion" element
             */
            java.lang.String getAprobacion();
            
            /**
             * Gets (as xml) the "Aprobacion" element
             */
            org.apache.xmlbeans.XmlString xgetAprobacion();
            
            /**
             * Sets the "Aprobacion" element
             */
            void setAprobacion(java.lang.String aprobacion);
            
            /**
             * Sets (as xml) the "Aprobacion" element
             */
            void xsetAprobacion(org.apache.xmlbeans.XmlString aprobacion);
            
            /**
             * A factory class with static methods for creating instances
             * of this type.
             */
            
            public static final class Factory
            {
                public static cl.tesoreria.sii.msgSII.MessageDocument.Message.Resultado newInstance() {
                  return (cl.tesoreria.sii.msgSII.MessageDocument.Message.Resultado) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
                
                public static cl.tesoreria.sii.msgSII.MessageDocument.Message.Resultado newInstance(org.apache.xmlbeans.XmlOptions options) {
                  return (cl.tesoreria.sii.msgSII.MessageDocument.Message.Resultado) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
                
                private Factory() { } // No instance of this class allowed
            }
        }
        
        /**
         * An XML Errores(@http://tesoreria.cl/sii/MsgSII.xsd).
         *
         * This is a complex type.
         */
        public interface Errores extends org.apache.xmlbeans.XmlObject
        {
            public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
                org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(Errores.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.MensajeMETypeSystem").resolveHandle("erroresca76elemtype");
            
            /**
             * Gets a List of "Error" elements
             */
            java.util.List<cl.tesoreria.sii.msgSII.MessageDocument.Message.Errores.Error> getErrorList();
            
            /**
             * Gets array of all "Error" elements
             * @deprecated
             */
            cl.tesoreria.sii.msgSII.MessageDocument.Message.Errores.Error[] getErrorArray();
            
            /**
             * Gets ith "Error" element
             */
            cl.tesoreria.sii.msgSII.MessageDocument.Message.Errores.Error getErrorArray(int i);
            
            /**
             * Returns number of "Error" element
             */
            int sizeOfErrorArray();
            
            /**
             * Sets array of all "Error" element
             */
            void setErrorArray(cl.tesoreria.sii.msgSII.MessageDocument.Message.Errores.Error[] errorArray);
            
            /**
             * Sets ith "Error" element
             */
            void setErrorArray(int i, cl.tesoreria.sii.msgSII.MessageDocument.Message.Errores.Error error);
            
            /**
             * Inserts and returns a new empty value (as xml) as the ith "Error" element
             */
            cl.tesoreria.sii.msgSII.MessageDocument.Message.Errores.Error insertNewError(int i);
            
            /**
             * Appends and returns a new empty value (as xml) as the last "Error" element
             */
            cl.tesoreria.sii.msgSII.MessageDocument.Message.Errores.Error addNewError();
            
            /**
             * Removes the ith "Error" element
             */
            void removeError(int i);
            
            /**
             * An XML Error(@http://tesoreria.cl/sii/MsgSII.xsd).
             *
             * This is a complex type.
             */
            public interface Error extends org.apache.xmlbeans.XmlObject
            {
                public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
                    org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(Error.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.MensajeMETypeSystem").resolveHandle("errorfca2elemtype");
                
                /**
                 * Gets the "ErrorNro" element
                 */
                java.math.BigDecimal getErrorNro();
                
                /**
                 * Gets (as xml) the "ErrorNro" element
                 */
                org.apache.xmlbeans.XmlDecimal xgetErrorNro();
                
                /**
                 * Sets the "ErrorNro" element
                 */
                void setErrorNro(java.math.BigDecimal errorNro);
                
                /**
                 * Sets (as xml) the "ErrorNro" element
                 */
                void xsetErrorNro(org.apache.xmlbeans.XmlDecimal errorNro);
                
                /**
                 * Gets the "Formulario" element
                 */
                java.math.BigDecimal getFormulario();
                
                /**
                 * Gets (as xml) the "Formulario" element
                 */
                org.apache.xmlbeans.XmlDecimal xgetFormulario();
                
                /**
                 * Sets the "Formulario" element
                 */
                void setFormulario(java.math.BigDecimal formulario);
                
                /**
                 * Sets (as xml) the "Formulario" element
                 */
                void xsetFormulario(org.apache.xmlbeans.XmlDecimal formulario);
                
                /**
                 * Gets the "Codigo" element
                 */
                java.lang.String getCodigo();
                
                /**
                 * Gets (as xml) the "Codigo" element
                 */
                org.apache.xmlbeans.XmlString xgetCodigo();
                
                /**
                 * Sets the "Codigo" element
                 */
                void setCodigo(java.lang.String codigo);
                
                /**
                 * Sets (as xml) the "Codigo" element
                 */
                void xsetCodigo(org.apache.xmlbeans.XmlString codigo);
                
                /**
                 * Gets the "Contenido" element
                 */
                java.lang.String getContenido();
                
                /**
                 * Gets (as xml) the "Contenido" element
                 */
                org.apache.xmlbeans.XmlString xgetContenido();
                
                /**
                 * Sets the "Contenido" element
                 */
                void setContenido(java.lang.String contenido);
                
                /**
                 * Sets (as xml) the "Contenido" element
                 */
                void xsetContenido(org.apache.xmlbeans.XmlString contenido);
                
                /**
                 * Gets the "Glosa" element
                 */
                java.lang.String getGlosa();
                
                /**
                 * Gets (as xml) the "Glosa" element
                 */
                org.apache.xmlbeans.XmlString xgetGlosa();
                
                /**
                 * Sets the "Glosa" element
                 */
                void setGlosa(java.lang.String glosa);
                
                /**
                 * Sets (as xml) the "Glosa" element
                 */
                void xsetGlosa(org.apache.xmlbeans.XmlString glosa);
                
                /**
                 * A factory class with static methods for creating instances
                 * of this type.
                 */
                
                public static final class Factory
                {
                    public static cl.tesoreria.sii.msgSII.MessageDocument.Message.Errores.Error newInstance() {
                      return (cl.tesoreria.sii.msgSII.MessageDocument.Message.Errores.Error) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
                    
                    public static cl.tesoreria.sii.msgSII.MessageDocument.Message.Errores.Error newInstance(org.apache.xmlbeans.XmlOptions options) {
                      return (cl.tesoreria.sii.msgSII.MessageDocument.Message.Errores.Error) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
                    
                    private Factory() { } // No instance of this class allowed
                }
            }
            
            /**
             * A factory class with static methods for creating instances
             * of this type.
             */
            
            public static final class Factory
            {
                public static cl.tesoreria.sii.msgSII.MessageDocument.Message.Errores newInstance() {
                  return (cl.tesoreria.sii.msgSII.MessageDocument.Message.Errores) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
                
                public static cl.tesoreria.sii.msgSII.MessageDocument.Message.Errores newInstance(org.apache.xmlbeans.XmlOptions options) {
                  return (cl.tesoreria.sii.msgSII.MessageDocument.Message.Errores) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
                
                private Factory() { } // No instance of this class allowed
            }
        }
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static cl.tesoreria.sii.msgSII.MessageDocument.Message newInstance() {
              return (cl.tesoreria.sii.msgSII.MessageDocument.Message) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static cl.tesoreria.sii.msgSII.MessageDocument.Message newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (cl.tesoreria.sii.msgSII.MessageDocument.Message) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static cl.tesoreria.sii.msgSII.MessageDocument newInstance() {
          return (cl.tesoreria.sii.msgSII.MessageDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static cl.tesoreria.sii.msgSII.MessageDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (cl.tesoreria.sii.msgSII.MessageDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static cl.tesoreria.sii.msgSII.MessageDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (cl.tesoreria.sii.msgSII.MessageDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static cl.tesoreria.sii.msgSII.MessageDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (cl.tesoreria.sii.msgSII.MessageDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static cl.tesoreria.sii.msgSII.MessageDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cl.tesoreria.sii.msgSII.MessageDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static cl.tesoreria.sii.msgSII.MessageDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cl.tesoreria.sii.msgSII.MessageDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static cl.tesoreria.sii.msgSII.MessageDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cl.tesoreria.sii.msgSII.MessageDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static cl.tesoreria.sii.msgSII.MessageDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cl.tesoreria.sii.msgSII.MessageDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static cl.tesoreria.sii.msgSII.MessageDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cl.tesoreria.sii.msgSII.MessageDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static cl.tesoreria.sii.msgSII.MessageDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cl.tesoreria.sii.msgSII.MessageDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static cl.tesoreria.sii.msgSII.MessageDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cl.tesoreria.sii.msgSII.MessageDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static cl.tesoreria.sii.msgSII.MessageDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cl.tesoreria.sii.msgSII.MessageDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static cl.tesoreria.sii.msgSII.MessageDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (cl.tesoreria.sii.msgSII.MessageDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static cl.tesoreria.sii.msgSII.MessageDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (cl.tesoreria.sii.msgSII.MessageDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static cl.tesoreria.sii.msgSII.MessageDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (cl.tesoreria.sii.msgSII.MessageDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static cl.tesoreria.sii.msgSII.MessageDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (cl.tesoreria.sii.msgSII.MessageDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static cl.tesoreria.sii.msgSII.MessageDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (cl.tesoreria.sii.msgSII.MessageDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static cl.tesoreria.sii.msgSII.MessageDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (cl.tesoreria.sii.msgSII.MessageDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
