/*
 * An XML document type.
 * Localname: Message
 * Namespace: http://tesoreria.cl/sii/MsgSII.xsd
 * Java type: cl.tesoreria.sii.msgSII.MessageDocument
 *
 * Automatically generated - do not modify.
 */
package cl.tesoreria.sii.msgSII.impl;
/**
 * A document containing one Message(@http://tesoreria.cl/sii/MsgSII.xsd) element.
 *
 * This is a complex type.
 */
public class MessageDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements cl.tesoreria.sii.msgSII.MessageDocument
{
    
    public MessageDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName MESSAGE$0 = 
        new javax.xml.namespace.QName("http://tesoreria.cl/sii/MsgSII.xsd", "Message");
    
    
    /**
     * Gets the "Message" element
     */
    public cl.tesoreria.sii.msgSII.MessageDocument.Message getMessage()
    {
        synchronized (monitor())
        {
            check_orphaned();
            cl.tesoreria.sii.msgSII.MessageDocument.Message target = null;
            target = (cl.tesoreria.sii.msgSII.MessageDocument.Message)get_store().find_element_user(MESSAGE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "Message" element
     */
    public void setMessage(cl.tesoreria.sii.msgSII.MessageDocument.Message message)
    {
        synchronized (monitor())
        {
            check_orphaned();
            cl.tesoreria.sii.msgSII.MessageDocument.Message target = null;
            target = (cl.tesoreria.sii.msgSII.MessageDocument.Message)get_store().find_element_user(MESSAGE$0, 0);
            if (target == null)
            {
                target = (cl.tesoreria.sii.msgSII.MessageDocument.Message)get_store().add_element_user(MESSAGE$0);
            }
            target.set(message);
        }
    }
    
    /**
     * Appends and returns a new empty "Message" element
     */
    public cl.tesoreria.sii.msgSII.MessageDocument.Message addNewMessage()
    {
        synchronized (monitor())
        {
            check_orphaned();
            cl.tesoreria.sii.msgSII.MessageDocument.Message target = null;
            target = (cl.tesoreria.sii.msgSII.MessageDocument.Message)get_store().add_element_user(MESSAGE$0);
            return target;
        }
    }
    /**
     * An XML Message(@http://tesoreria.cl/sii/MsgSII.xsd).
     *
     * This is a complex type.
     */
    public static class MessageImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements cl.tesoreria.sii.msgSII.MessageDocument.Message
    {
        
        public MessageImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName MESSAGEID$0 = 
            new javax.xml.namespace.QName("http://tesoreria.cl/sii/MsgSII.xsd", "MessageId");
        private static final javax.xml.namespace.QName DETALLE$2 = 
            new javax.xml.namespace.QName("http://tesoreria.cl/sii/MsgSII.xsd", "Detalle");
        private static final javax.xml.namespace.QName RESULTADO$4 = 
            new javax.xml.namespace.QName("http://tesoreria.cl/sii/MsgSII.xsd", "Resultado");
        private static final javax.xml.namespace.QName ERRORES$6 = 
            new javax.xml.namespace.QName("http://tesoreria.cl/sii/MsgSII.xsd", "Errores");
        
        
        /**
         * Gets the "MessageId" element
         */
        public cl.tesoreria.sii.msgSII.MessageDocument.Message.MessageId getMessageId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                cl.tesoreria.sii.msgSII.MessageDocument.Message.MessageId target = null;
                target = (cl.tesoreria.sii.msgSII.MessageDocument.Message.MessageId)get_store().find_element_user(MESSAGEID$0, 0);
                if (target == null)
                {
                    return null;
                }
                return target;
            }
        }
        
        /**
         * Sets the "MessageId" element
         */
        public void setMessageId(cl.tesoreria.sii.msgSII.MessageDocument.Message.MessageId messageId)
        {
            synchronized (monitor())
            {
                check_orphaned();
                cl.tesoreria.sii.msgSII.MessageDocument.Message.MessageId target = null;
                target = (cl.tesoreria.sii.msgSII.MessageDocument.Message.MessageId)get_store().find_element_user(MESSAGEID$0, 0);
                if (target == null)
                {
                    target = (cl.tesoreria.sii.msgSII.MessageDocument.Message.MessageId)get_store().add_element_user(MESSAGEID$0);
                }
                target.set(messageId);
            }
        }
        
        /**
         * Appends and returns a new empty "MessageId" element
         */
        public cl.tesoreria.sii.msgSII.MessageDocument.Message.MessageId addNewMessageId()
        {
            synchronized (monitor())
            {
                check_orphaned();
                cl.tesoreria.sii.msgSII.MessageDocument.Message.MessageId target = null;
                target = (cl.tesoreria.sii.msgSII.MessageDocument.Message.MessageId)get_store().add_element_user(MESSAGEID$0);
                return target;
            }
        }
        
        /**
         * Gets the "Detalle" element
         */
        public cl.tesoreria.sii.msgSII.MessageDocument.Message.Detalle getDetalle()
        {
            synchronized (monitor())
            {
                check_orphaned();
                cl.tesoreria.sii.msgSII.MessageDocument.Message.Detalle target = null;
                target = (cl.tesoreria.sii.msgSII.MessageDocument.Message.Detalle)get_store().find_element_user(DETALLE$2, 0);
                if (target == null)
                {
                    return null;
                }
                return target;
            }
        }
        
        /**
         * Sets the "Detalle" element
         */
        public void setDetalle(cl.tesoreria.sii.msgSII.MessageDocument.Message.Detalle detalle)
        {
            synchronized (monitor())
            {
                check_orphaned();
                cl.tesoreria.sii.msgSII.MessageDocument.Message.Detalle target = null;
                target = (cl.tesoreria.sii.msgSII.MessageDocument.Message.Detalle)get_store().find_element_user(DETALLE$2, 0);
                if (target == null)
                {
                    target = (cl.tesoreria.sii.msgSII.MessageDocument.Message.Detalle)get_store().add_element_user(DETALLE$2);
                }
                target.set(detalle);
            }
        }
        
        /**
         * Appends and returns a new empty "Detalle" element
         */
        public cl.tesoreria.sii.msgSII.MessageDocument.Message.Detalle addNewDetalle()
        {
            synchronized (monitor())
            {
                check_orphaned();
                cl.tesoreria.sii.msgSII.MessageDocument.Message.Detalle target = null;
                target = (cl.tesoreria.sii.msgSII.MessageDocument.Message.Detalle)get_store().add_element_user(DETALLE$2);
                return target;
            }
        }
        
        /**
         * Gets the "Resultado" element
         */
        public cl.tesoreria.sii.msgSII.MessageDocument.Message.Resultado getResultado()
        {
            synchronized (monitor())
            {
                check_orphaned();
                cl.tesoreria.sii.msgSII.MessageDocument.Message.Resultado target = null;
                target = (cl.tesoreria.sii.msgSII.MessageDocument.Message.Resultado)get_store().find_element_user(RESULTADO$4, 0);
                if (target == null)
                {
                    return null;
                }
                return target;
            }
        }
        
        /**
         * Sets the "Resultado" element
         */
        public void setResultado(cl.tesoreria.sii.msgSII.MessageDocument.Message.Resultado resultado)
        {
            synchronized (monitor())
            {
                check_orphaned();
                cl.tesoreria.sii.msgSII.MessageDocument.Message.Resultado target = null;
                target = (cl.tesoreria.sii.msgSII.MessageDocument.Message.Resultado)get_store().find_element_user(RESULTADO$4, 0);
                if (target == null)
                {
                    target = (cl.tesoreria.sii.msgSII.MessageDocument.Message.Resultado)get_store().add_element_user(RESULTADO$4);
                }
                target.set(resultado);
            }
        }
        
        /**
         * Appends and returns a new empty "Resultado" element
         */
        public cl.tesoreria.sii.msgSII.MessageDocument.Message.Resultado addNewResultado()
        {
            synchronized (monitor())
            {
                check_orphaned();
                cl.tesoreria.sii.msgSII.MessageDocument.Message.Resultado target = null;
                target = (cl.tesoreria.sii.msgSII.MessageDocument.Message.Resultado)get_store().add_element_user(RESULTADO$4);
                return target;
            }
        }
        
        /**
         * Gets the "Errores" element
         */
        public cl.tesoreria.sii.msgSII.MessageDocument.Message.Errores getErrores()
        {
            synchronized (monitor())
            {
                check_orphaned();
                cl.tesoreria.sii.msgSII.MessageDocument.Message.Errores target = null;
                target = (cl.tesoreria.sii.msgSII.MessageDocument.Message.Errores)get_store().find_element_user(ERRORES$6, 0);
                if (target == null)
                {
                    return null;
                }
                return target;
            }
        }
        
        /**
         * True if has "Errores" element
         */
        public boolean isSetErrores()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(ERRORES$6) != 0;
            }
        }
        
        /**
         * Sets the "Errores" element
         */
        public void setErrores(cl.tesoreria.sii.msgSII.MessageDocument.Message.Errores errores)
        {
            synchronized (monitor())
            {
                check_orphaned();
                cl.tesoreria.sii.msgSII.MessageDocument.Message.Errores target = null;
                target = (cl.tesoreria.sii.msgSII.MessageDocument.Message.Errores)get_store().find_element_user(ERRORES$6, 0);
                if (target == null)
                {
                    target = (cl.tesoreria.sii.msgSII.MessageDocument.Message.Errores)get_store().add_element_user(ERRORES$6);
                }
                target.set(errores);
            }
        }
        
        /**
         * Appends and returns a new empty "Errores" element
         */
        public cl.tesoreria.sii.msgSII.MessageDocument.Message.Errores addNewErrores()
        {
            synchronized (monitor())
            {
                check_orphaned();
                cl.tesoreria.sii.msgSII.MessageDocument.Message.Errores target = null;
                target = (cl.tesoreria.sii.msgSII.MessageDocument.Message.Errores)get_store().add_element_user(ERRORES$6);
                return target;
            }
        }
        
        /**
         * Unsets the "Errores" element
         */
        public void unsetErrores()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(ERRORES$6, 0);
            }
        }
        /**
         * An XML MessageId(@http://tesoreria.cl/sii/MsgSII.xsd).
         *
         * This is a complex type.
         */
        public static class MessageIdImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements cl.tesoreria.sii.msgSII.MessageDocument.Message.MessageId
        {
            
            public MessageIdImpl(org.apache.xmlbeans.SchemaType sType)
            {
                super(sType);
            }
            
            private static final javax.xml.namespace.QName CODE$0 = 
                new javax.xml.namespace.QName("http://tesoreria.cl/sii/MsgSII.xsd", "Code");
            private static final javax.xml.namespace.QName MSGDESC$2 = 
                new javax.xml.namespace.QName("http://tesoreria.cl/sii/MsgSII.xsd", "MsgDesc");
            private static final javax.xml.namespace.QName VERSION$4 = 
                new javax.xml.namespace.QName("http://tesoreria.cl/sii/MsgSII.xsd", "Version");
            private static final javax.xml.namespace.QName FROMADDRESS$6 = 
                new javax.xml.namespace.QName("http://tesoreria.cl/sii/MsgSII.xsd", "FromAddress");
            private static final javax.xml.namespace.QName TOADDRESS$8 = 
                new javax.xml.namespace.QName("http://tesoreria.cl/sii/MsgSII.xsd", "ToAddress");
            private static final javax.xml.namespace.QName REFADDRESS$10 = 
                new javax.xml.namespace.QName("http://tesoreria.cl/sii/MsgSII.xsd", "RefAddress");
            private static final javax.xml.namespace.QName VALIDADO$12 = 
                new javax.xml.namespace.QName("http://tesoreria.cl/sii/MsgSII.xsd", "Validado");
            private static final javax.xml.namespace.QName NUMBER$14 = 
                new javax.xml.namespace.QName("http://tesoreria.cl/sii/MsgSII.xsd", "Number");
            
            
            /**
             * Gets the "Code" element
             */
            public java.lang.String getCode()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CODE$0, 0);
                    if (target == null)
                    {
                      return null;
                    }
                    return target.getStringValue();
                }
            }
            
            /**
             * Gets (as xml) the "Code" element
             */
            public org.apache.xmlbeans.XmlString xgetCode()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlString target = null;
                    target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(CODE$0, 0);
                    return target;
                }
            }
            
            /**
             * Sets the "Code" element
             */
            public void setCode(java.lang.String code)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CODE$0, 0);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(CODE$0);
                    }
                    target.setStringValue(code);
                }
            }
            
            /**
             * Sets (as xml) the "Code" element
             */
            public void xsetCode(org.apache.xmlbeans.XmlString code)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlString target = null;
                    target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(CODE$0, 0);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(CODE$0);
                    }
                    target.set(code);
                }
            }
            
            /**
             * Gets the "MsgDesc" element
             */
            public java.lang.String getMsgDesc()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(MSGDESC$2, 0);
                    if (target == null)
                    {
                      return null;
                    }
                    return target.getStringValue();
                }
            }
            
            /**
             * Gets (as xml) the "MsgDesc" element
             */
            public org.apache.xmlbeans.XmlString xgetMsgDesc()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlString target = null;
                    target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(MSGDESC$2, 0);
                    return target;
                }
            }
            
            /**
             * Sets the "MsgDesc" element
             */
            public void setMsgDesc(java.lang.String msgDesc)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(MSGDESC$2, 0);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(MSGDESC$2);
                    }
                    target.setStringValue(msgDesc);
                }
            }
            
            /**
             * Sets (as xml) the "MsgDesc" element
             */
            public void xsetMsgDesc(org.apache.xmlbeans.XmlString msgDesc)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlString target = null;
                    target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(MSGDESC$2, 0);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(MSGDESC$2);
                    }
                    target.set(msgDesc);
                }
            }
            
            /**
             * Gets the "Version" element
             */
            public long getVersion()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(VERSION$4, 0);
                    if (target == null)
                    {
                      return 0L;
                    }
                    return target.getLongValue();
                }
            }
            
            /**
             * Gets (as xml) the "Version" element
             */
            public org.apache.xmlbeans.XmlLong xgetVersion()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlLong target = null;
                    target = (org.apache.xmlbeans.XmlLong)get_store().find_element_user(VERSION$4, 0);
                    return target;
                }
            }
            
            /**
             * Sets the "Version" element
             */
            public void setVersion(long version)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(VERSION$4, 0);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(VERSION$4);
                    }
                    target.setLongValue(version);
                }
            }
            
            /**
             * Sets (as xml) the "Version" element
             */
            public void xsetVersion(org.apache.xmlbeans.XmlLong version)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlLong target = null;
                    target = (org.apache.xmlbeans.XmlLong)get_store().find_element_user(VERSION$4, 0);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.XmlLong)get_store().add_element_user(VERSION$4);
                    }
                    target.set(version);
                }
            }
            
            /**
             * Gets the "FromAddress" element
             */
            public java.lang.String getFromAddress()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FROMADDRESS$6, 0);
                    if (target == null)
                    {
                      return null;
                    }
                    return target.getStringValue();
                }
            }
            
            /**
             * Gets (as xml) the "FromAddress" element
             */
            public org.apache.xmlbeans.XmlString xgetFromAddress()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlString target = null;
                    target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(FROMADDRESS$6, 0);
                    return target;
                }
            }
            
            /**
             * Sets the "FromAddress" element
             */
            public void setFromAddress(java.lang.String fromAddress)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FROMADDRESS$6, 0);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(FROMADDRESS$6);
                    }
                    target.setStringValue(fromAddress);
                }
            }
            
            /**
             * Sets (as xml) the "FromAddress" element
             */
            public void xsetFromAddress(org.apache.xmlbeans.XmlString fromAddress)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlString target = null;
                    target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(FROMADDRESS$6, 0);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(FROMADDRESS$6);
                    }
                    target.set(fromAddress);
                }
            }
            
            /**
             * Gets the "ToAddress" element
             */
            public java.lang.String getToAddress()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TOADDRESS$8, 0);
                    if (target == null)
                    {
                      return null;
                    }
                    return target.getStringValue();
                }
            }
            
            /**
             * Gets (as xml) the "ToAddress" element
             */
            public org.apache.xmlbeans.XmlString xgetToAddress()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlString target = null;
                    target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(TOADDRESS$8, 0);
                    return target;
                }
            }
            
            /**
             * Sets the "ToAddress" element
             */
            public void setToAddress(java.lang.String toAddress)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TOADDRESS$8, 0);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(TOADDRESS$8);
                    }
                    target.setStringValue(toAddress);
                }
            }
            
            /**
             * Sets (as xml) the "ToAddress" element
             */
            public void xsetToAddress(org.apache.xmlbeans.XmlString toAddress)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlString target = null;
                    target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(TOADDRESS$8, 0);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(TOADDRESS$8);
                    }
                    target.set(toAddress);
                }
            }
            
            /**
             * Gets the "RefAddress" element
             */
            public java.math.BigDecimal getRefAddress()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(REFADDRESS$10, 0);
                    if (target == null)
                    {
                      return null;
                    }
                    return target.getBigDecimalValue();
                }
            }
            
            /**
             * Gets (as xml) the "RefAddress" element
             */
            public org.apache.xmlbeans.XmlDecimal xgetRefAddress()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlDecimal target = null;
                    target = (org.apache.xmlbeans.XmlDecimal)get_store().find_element_user(REFADDRESS$10, 0);
                    return target;
                }
            }
            
            /**
             * Sets the "RefAddress" element
             */
            public void setRefAddress(java.math.BigDecimal refAddress)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(REFADDRESS$10, 0);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(REFADDRESS$10);
                    }
                    target.setBigDecimalValue(refAddress);
                }
            }
            
            /**
             * Sets (as xml) the "RefAddress" element
             */
            public void xsetRefAddress(org.apache.xmlbeans.XmlDecimal refAddress)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlDecimal target = null;
                    target = (org.apache.xmlbeans.XmlDecimal)get_store().find_element_user(REFADDRESS$10, 0);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.XmlDecimal)get_store().add_element_user(REFADDRESS$10);
                    }
                    target.set(refAddress);
                }
            }
            
            /**
             * Gets the "Validado" element
             */
            public java.lang.String getValidado()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(VALIDADO$12, 0);
                    if (target == null)
                    {
                      return null;
                    }
                    return target.getStringValue();
                }
            }
            
            /**
             * Gets (as xml) the "Validado" element
             */
            public org.apache.xmlbeans.XmlString xgetValidado()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlString target = null;
                    target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(VALIDADO$12, 0);
                    return target;
                }
            }
            
            /**
             * Sets the "Validado" element
             */
            public void setValidado(java.lang.String validado)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(VALIDADO$12, 0);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(VALIDADO$12);
                    }
                    target.setStringValue(validado);
                }
            }
            
            /**
             * Sets (as xml) the "Validado" element
             */
            public void xsetValidado(org.apache.xmlbeans.XmlString validado)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlString target = null;
                    target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(VALIDADO$12, 0);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(VALIDADO$12);
                    }
                    target.set(validado);
                }
            }
            
            /**
             * Gets the "Number" element
             */
            public java.math.BigDecimal getNumber()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(NUMBER$14, 0);
                    if (target == null)
                    {
                      return null;
                    }
                    return target.getBigDecimalValue();
                }
            }
            
            /**
             * Gets (as xml) the "Number" element
             */
            public org.apache.xmlbeans.XmlDecimal xgetNumber()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlDecimal target = null;
                    target = (org.apache.xmlbeans.XmlDecimal)get_store().find_element_user(NUMBER$14, 0);
                    return target;
                }
            }
            
            /**
             * Sets the "Number" element
             */
            public void setNumber(java.math.BigDecimal number)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(NUMBER$14, 0);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(NUMBER$14);
                    }
                    target.setBigDecimalValue(number);
                }
            }
            
            /**
             * Sets (as xml) the "Number" element
             */
            public void xsetNumber(org.apache.xmlbeans.XmlDecimal number)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlDecimal target = null;
                    target = (org.apache.xmlbeans.XmlDecimal)get_store().find_element_user(NUMBER$14, 0);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.XmlDecimal)get_store().add_element_user(NUMBER$14);
                    }
                    target.set(number);
                }
            }
        }
        /**
         * An XML Detalle(@http://tesoreria.cl/sii/MsgSII.xsd).
         *
         * This is a complex type.
         */
        public static class DetalleImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements cl.tesoreria.sii.msgSII.MessageDocument.Message.Detalle
        {
            
            public DetalleImpl(org.apache.xmlbeans.SchemaType sType)
            {
                super(sType);
            }
            
            private static final javax.xml.namespace.QName TIPOREGISTRO$0 = 
                new javax.xml.namespace.QName("http://tesoreria.cl/sii/MsgSII.xsd", "TipoRegistro");
            private static final javax.xml.namespace.QName RUTIRA$2 = 
                new javax.xml.namespace.QName("http://tesoreria.cl/sii/MsgSII.xsd", "RutIra");
            private static final javax.xml.namespace.QName DVIRA$4 = 
                new javax.xml.namespace.QName("http://tesoreria.cl/sii/MsgSII.xsd", "DvIra");
            private static final javax.xml.namespace.QName FOLIOF01$6 = 
                new javax.xml.namespace.QName("http://tesoreria.cl/sii/MsgSII.xsd", "FolioF01");
            private static final javax.xml.namespace.QName FECHARECEPCION$8 = 
                new javax.xml.namespace.QName("http://tesoreria.cl/sii/MsgSII.xsd", "FechaRecepcion");
            private static final javax.xml.namespace.QName RUTCONTR$10 = 
                new javax.xml.namespace.QName("http://tesoreria.cl/sii/MsgSII.xsd", "RutContr");
            private static final javax.xml.namespace.QName DVCONTR$12 = 
                new javax.xml.namespace.QName("http://tesoreria.cl/sii/MsgSII.xsd", "DvContr");
            private static final javax.xml.namespace.QName FORMULARIO$14 = 
                new javax.xml.namespace.QName("http://tesoreria.cl/sii/MsgSII.xsd", "Formulario");
            private static final javax.xml.namespace.QName FOLIO$16 = 
                new javax.xml.namespace.QName("http://tesoreria.cl/sii/MsgSII.xsd", "Folio");
            private static final javax.xml.namespace.QName PERIODO$18 = 
                new javax.xml.namespace.QName("http://tesoreria.cl/sii/MsgSII.xsd", "Periodo");
            
            
            /**
             * Gets the "TipoRegistro" element
             */
            public java.math.BigDecimal getTipoRegistro()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TIPOREGISTRO$0, 0);
                    if (target == null)
                    {
                      return null;
                    }
                    return target.getBigDecimalValue();
                }
            }
            
            /**
             * Gets (as xml) the "TipoRegistro" element
             */
            public org.apache.xmlbeans.XmlDecimal xgetTipoRegistro()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlDecimal target = null;
                    target = (org.apache.xmlbeans.XmlDecimal)get_store().find_element_user(TIPOREGISTRO$0, 0);
                    return target;
                }
            }
            
            /**
             * Sets the "TipoRegistro" element
             */
            public void setTipoRegistro(java.math.BigDecimal tipoRegistro)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TIPOREGISTRO$0, 0);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(TIPOREGISTRO$0);
                    }
                    target.setBigDecimalValue(tipoRegistro);
                }
            }
            
            /**
             * Sets (as xml) the "TipoRegistro" element
             */
            public void xsetTipoRegistro(org.apache.xmlbeans.XmlDecimal tipoRegistro)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlDecimal target = null;
                    target = (org.apache.xmlbeans.XmlDecimal)get_store().find_element_user(TIPOREGISTRO$0, 0);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.XmlDecimal)get_store().add_element_user(TIPOREGISTRO$0);
                    }
                    target.set(tipoRegistro);
                }
            }
            
            /**
             * Gets the "RutIra" element
             */
            public java.math.BigDecimal getRutIra()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(RUTIRA$2, 0);
                    if (target == null)
                    {
                      return null;
                    }
                    return target.getBigDecimalValue();
                }
            }
            
            /**
             * Gets (as xml) the "RutIra" element
             */
            public org.apache.xmlbeans.XmlDecimal xgetRutIra()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlDecimal target = null;
                    target = (org.apache.xmlbeans.XmlDecimal)get_store().find_element_user(RUTIRA$2, 0);
                    return target;
                }
            }
            
            /**
             * Sets the "RutIra" element
             */
            public void setRutIra(java.math.BigDecimal rutIra)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(RUTIRA$2, 0);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(RUTIRA$2);
                    }
                    target.setBigDecimalValue(rutIra);
                }
            }
            
            /**
             * Sets (as xml) the "RutIra" element
             */
            public void xsetRutIra(org.apache.xmlbeans.XmlDecimal rutIra)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlDecimal target = null;
                    target = (org.apache.xmlbeans.XmlDecimal)get_store().find_element_user(RUTIRA$2, 0);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.XmlDecimal)get_store().add_element_user(RUTIRA$2);
                    }
                    target.set(rutIra);
                }
            }
            
            /**
             * Gets the "DvIra" element
             */
            public java.lang.String getDvIra()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DVIRA$4, 0);
                    if (target == null)
                    {
                      return null;
                    }
                    return target.getStringValue();
                }
            }
            
            /**
             * Gets (as xml) the "DvIra" element
             */
            public org.apache.xmlbeans.XmlString xgetDvIra()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlString target = null;
                    target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(DVIRA$4, 0);
                    return target;
                }
            }
            
            /**
             * Sets the "DvIra" element
             */
            public void setDvIra(java.lang.String dvIra)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DVIRA$4, 0);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(DVIRA$4);
                    }
                    target.setStringValue(dvIra);
                }
            }
            
            /**
             * Sets (as xml) the "DvIra" element
             */
            public void xsetDvIra(org.apache.xmlbeans.XmlString dvIra)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlString target = null;
                    target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(DVIRA$4, 0);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(DVIRA$4);
                    }
                    target.set(dvIra);
                }
            }
            
            /**
             * Gets the "FolioF01" element
             */
            public java.math.BigDecimal getFolioF01()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FOLIOF01$6, 0);
                    if (target == null)
                    {
                      return null;
                    }
                    return target.getBigDecimalValue();
                }
            }
            
            /**
             * Gets (as xml) the "FolioF01" element
             */
            public org.apache.xmlbeans.XmlDecimal xgetFolioF01()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlDecimal target = null;
                    target = (org.apache.xmlbeans.XmlDecimal)get_store().find_element_user(FOLIOF01$6, 0);
                    return target;
                }
            }
            
            /**
             * Sets the "FolioF01" element
             */
            public void setFolioF01(java.math.BigDecimal folioF01)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FOLIOF01$6, 0);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(FOLIOF01$6);
                    }
                    target.setBigDecimalValue(folioF01);
                }
            }
            
            /**
             * Sets (as xml) the "FolioF01" element
             */
            public void xsetFolioF01(org.apache.xmlbeans.XmlDecimal folioF01)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlDecimal target = null;
                    target = (org.apache.xmlbeans.XmlDecimal)get_store().find_element_user(FOLIOF01$6, 0);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.XmlDecimal)get_store().add_element_user(FOLIOF01$6);
                    }
                    target.set(folioF01);
                }
            }
            
            /**
             * Gets the "FechaRecepcion" element
             */
            public java.math.BigDecimal getFechaRecepcion()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FECHARECEPCION$8, 0);
                    if (target == null)
                    {
                      return null;
                    }
                    return target.getBigDecimalValue();
                }
            }
            
            /**
             * Gets (as xml) the "FechaRecepcion" element
             */
            public org.apache.xmlbeans.XmlDecimal xgetFechaRecepcion()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlDecimal target = null;
                    target = (org.apache.xmlbeans.XmlDecimal)get_store().find_element_user(FECHARECEPCION$8, 0);
                    return target;
                }
            }
            
            /**
             * Sets the "FechaRecepcion" element
             */
            public void setFechaRecepcion(java.math.BigDecimal fechaRecepcion)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FECHARECEPCION$8, 0);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(FECHARECEPCION$8);
                    }
                    target.setBigDecimalValue(fechaRecepcion);
                }
            }
            
            /**
             * Sets (as xml) the "FechaRecepcion" element
             */
            public void xsetFechaRecepcion(org.apache.xmlbeans.XmlDecimal fechaRecepcion)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlDecimal target = null;
                    target = (org.apache.xmlbeans.XmlDecimal)get_store().find_element_user(FECHARECEPCION$8, 0);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.XmlDecimal)get_store().add_element_user(FECHARECEPCION$8);
                    }
                    target.set(fechaRecepcion);
                }
            }
            
            /**
             * Gets the "RutContr" element
             */
            public java.math.BigDecimal getRutContr()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(RUTCONTR$10, 0);
                    if (target == null)
                    {
                      return null;
                    }
                    return target.getBigDecimalValue();
                }
            }
            
            /**
             * Gets (as xml) the "RutContr" element
             */
            public org.apache.xmlbeans.XmlDecimal xgetRutContr()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlDecimal target = null;
                    target = (org.apache.xmlbeans.XmlDecimal)get_store().find_element_user(RUTCONTR$10, 0);
                    return target;
                }
            }
            
            /**
             * Sets the "RutContr" element
             */
            public void setRutContr(java.math.BigDecimal rutContr)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(RUTCONTR$10, 0);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(RUTCONTR$10);
                    }
                    target.setBigDecimalValue(rutContr);
                }
            }
            
            /**
             * Sets (as xml) the "RutContr" element
             */
            public void xsetRutContr(org.apache.xmlbeans.XmlDecimal rutContr)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlDecimal target = null;
                    target = (org.apache.xmlbeans.XmlDecimal)get_store().find_element_user(RUTCONTR$10, 0);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.XmlDecimal)get_store().add_element_user(RUTCONTR$10);
                    }
                    target.set(rutContr);
                }
            }
            
            /**
             * Gets the "DvContr" element
             */
            public java.lang.String getDvContr()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DVCONTR$12, 0);
                    if (target == null)
                    {
                      return null;
                    }
                    return target.getStringValue();
                }
            }
            
            /**
             * Gets (as xml) the "DvContr" element
             */
            public org.apache.xmlbeans.XmlString xgetDvContr()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlString target = null;
                    target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(DVCONTR$12, 0);
                    return target;
                }
            }
            
            /**
             * Sets the "DvContr" element
             */
            public void setDvContr(java.lang.String dvContr)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DVCONTR$12, 0);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(DVCONTR$12);
                    }
                    target.setStringValue(dvContr);
                }
            }
            
            /**
             * Sets (as xml) the "DvContr" element
             */
            public void xsetDvContr(org.apache.xmlbeans.XmlString dvContr)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlString target = null;
                    target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(DVCONTR$12, 0);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(DVCONTR$12);
                    }
                    target.set(dvContr);
                }
            }
            
            /**
             * Gets the "Formulario" element
             */
            public java.math.BigDecimal getFormulario()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FORMULARIO$14, 0);
                    if (target == null)
                    {
                      return null;
                    }
                    return target.getBigDecimalValue();
                }
            }
            
            /**
             * Gets (as xml) the "Formulario" element
             */
            public org.apache.xmlbeans.XmlDecimal xgetFormulario()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlDecimal target = null;
                    target = (org.apache.xmlbeans.XmlDecimal)get_store().find_element_user(FORMULARIO$14, 0);
                    return target;
                }
            }
            
            /**
             * Sets the "Formulario" element
             */
            public void setFormulario(java.math.BigDecimal formulario)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FORMULARIO$14, 0);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(FORMULARIO$14);
                    }
                    target.setBigDecimalValue(formulario);
                }
            }
            
            /**
             * Sets (as xml) the "Formulario" element
             */
            public void xsetFormulario(org.apache.xmlbeans.XmlDecimal formulario)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlDecimal target = null;
                    target = (org.apache.xmlbeans.XmlDecimal)get_store().find_element_user(FORMULARIO$14, 0);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.XmlDecimal)get_store().add_element_user(FORMULARIO$14);
                    }
                    target.set(formulario);
                }
            }
            
            /**
             * Gets the "Folio" element
             */
            public java.math.BigDecimal getFolio()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FOLIO$16, 0);
                    if (target == null)
                    {
                      return null;
                    }
                    return target.getBigDecimalValue();
                }
            }
            
            /**
             * Gets (as xml) the "Folio" element
             */
            public org.apache.xmlbeans.XmlDecimal xgetFolio()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlDecimal target = null;
                    target = (org.apache.xmlbeans.XmlDecimal)get_store().find_element_user(FOLIO$16, 0);
                    return target;
                }
            }
            
            /**
             * Sets the "Folio" element
             */
            public void setFolio(java.math.BigDecimal folio)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FOLIO$16, 0);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(FOLIO$16);
                    }
                    target.setBigDecimalValue(folio);
                }
            }
            
            /**
             * Sets (as xml) the "Folio" element
             */
            public void xsetFolio(org.apache.xmlbeans.XmlDecimal folio)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlDecimal target = null;
                    target = (org.apache.xmlbeans.XmlDecimal)get_store().find_element_user(FOLIO$16, 0);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.XmlDecimal)get_store().add_element_user(FOLIO$16);
                    }
                    target.set(folio);
                }
            }
            
            /**
             * Gets the "Periodo" element
             */
            public java.math.BigDecimal getPeriodo()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PERIODO$18, 0);
                    if (target == null)
                    {
                      return null;
                    }
                    return target.getBigDecimalValue();
                }
            }
            
            /**
             * Gets (as xml) the "Periodo" element
             */
            public org.apache.xmlbeans.XmlDecimal xgetPeriodo()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlDecimal target = null;
                    target = (org.apache.xmlbeans.XmlDecimal)get_store().find_element_user(PERIODO$18, 0);
                    return target;
                }
            }
            
            /**
             * Sets the "Periodo" element
             */
            public void setPeriodo(java.math.BigDecimal periodo)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PERIODO$18, 0);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(PERIODO$18);
                    }
                    target.setBigDecimalValue(periodo);
                }
            }
            
            /**
             * Sets (as xml) the "Periodo" element
             */
            public void xsetPeriodo(org.apache.xmlbeans.XmlDecimal periodo)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlDecimal target = null;
                    target = (org.apache.xmlbeans.XmlDecimal)get_store().find_element_user(PERIODO$18, 0);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.XmlDecimal)get_store().add_element_user(PERIODO$18);
                    }
                    target.set(periodo);
                }
            }
        }
        /**
         * An XML Resultado(@http://tesoreria.cl/sii/MsgSII.xsd).
         *
         * This is a complex type.
         */
        public static class ResultadoImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements cl.tesoreria.sii.msgSII.MessageDocument.Message.Resultado
        {
            
            public ResultadoImpl(org.apache.xmlbeans.SchemaType sType)
            {
                super(sType);
            }
            
            private static final javax.xml.namespace.QName APROBACION$0 = 
                new javax.xml.namespace.QName("http://tesoreria.cl/sii/MsgSII.xsd", "Aprobacion");
            
            
            /**
             * Gets the "Aprobacion" element
             */
            public java.lang.String getAprobacion()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(APROBACION$0, 0);
                    if (target == null)
                    {
                      return null;
                    }
                    return target.getStringValue();
                }
            }
            
            /**
             * Gets (as xml) the "Aprobacion" element
             */
            public org.apache.xmlbeans.XmlString xgetAprobacion()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlString target = null;
                    target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(APROBACION$0, 0);
                    return target;
                }
            }
            
            /**
             * Sets the "Aprobacion" element
             */
            public void setAprobacion(java.lang.String aprobacion)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(APROBACION$0, 0);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(APROBACION$0);
                    }
                    target.setStringValue(aprobacion);
                }
            }
            
            /**
             * Sets (as xml) the "Aprobacion" element
             */
            public void xsetAprobacion(org.apache.xmlbeans.XmlString aprobacion)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlString target = null;
                    target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(APROBACION$0, 0);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(APROBACION$0);
                    }
                    target.set(aprobacion);
                }
            }
        }
        /**
         * An XML Errores(@http://tesoreria.cl/sii/MsgSII.xsd).
         *
         * This is a complex type.
         */
        public static class ErroresImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements cl.tesoreria.sii.msgSII.MessageDocument.Message.Errores
        {
            
            public ErroresImpl(org.apache.xmlbeans.SchemaType sType)
            {
                super(sType);
            }
            
            private static final javax.xml.namespace.QName ERROR$0 = 
                new javax.xml.namespace.QName("http://tesoreria.cl/sii/MsgSII.xsd", "Error");
            
            
            /**
             * Gets a List of "Error" elements
             */
            public java.util.List<cl.tesoreria.sii.msgSII.MessageDocument.Message.Errores.Error> getErrorList()
            {
                final class ErrorList extends java.util.AbstractList<cl.tesoreria.sii.msgSII.MessageDocument.Message.Errores.Error>
                {
                    public cl.tesoreria.sii.msgSII.MessageDocument.Message.Errores.Error get(int i)
                        { return ErroresImpl.this.getErrorArray(i); }
                    
                    public cl.tesoreria.sii.msgSII.MessageDocument.Message.Errores.Error set(int i, cl.tesoreria.sii.msgSII.MessageDocument.Message.Errores.Error o)
                    {
                      cl.tesoreria.sii.msgSII.MessageDocument.Message.Errores.Error old = ErroresImpl.this.getErrorArray(i);
                      ErroresImpl.this.setErrorArray(i, o);
                      return old;
                    }
                    
                    public void add(int i, cl.tesoreria.sii.msgSII.MessageDocument.Message.Errores.Error o)
                        { ErroresImpl.this.insertNewError(i).set(o); }
                    
                    public cl.tesoreria.sii.msgSII.MessageDocument.Message.Errores.Error remove(int i)
                    {
                      cl.tesoreria.sii.msgSII.MessageDocument.Message.Errores.Error old = ErroresImpl.this.getErrorArray(i);
                      ErroresImpl.this.removeError(i);
                      return old;
                    }
                    
                    public int size()
                        { return ErroresImpl.this.sizeOfErrorArray(); }
                    
                }
                
                synchronized (monitor())
                {
                    check_orphaned();
                    return new ErrorList();
                }
            }
            
            /**
             * Gets array of all "Error" elements
             */
            public cl.tesoreria.sii.msgSII.MessageDocument.Message.Errores.Error[] getErrorArray()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    java.util.List targetList = new java.util.ArrayList();
                    get_store().find_all_element_users(ERROR$0, targetList);
                    cl.tesoreria.sii.msgSII.MessageDocument.Message.Errores.Error[] result = new cl.tesoreria.sii.msgSII.MessageDocument.Message.Errores.Error[targetList.size()];
                    targetList.toArray(result);
                    return result;
                }
            }
            
            /**
             * Gets ith "Error" element
             */
            public cl.tesoreria.sii.msgSII.MessageDocument.Message.Errores.Error getErrorArray(int i)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    cl.tesoreria.sii.msgSII.MessageDocument.Message.Errores.Error target = null;
                    target = (cl.tesoreria.sii.msgSII.MessageDocument.Message.Errores.Error)get_store().find_element_user(ERROR$0, i);
                    if (target == null)
                    {
                      throw new IndexOutOfBoundsException();
                    }
                    return target;
                }
            }
            
            /**
             * Returns number of "Error" element
             */
            public int sizeOfErrorArray()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    return get_store().count_elements(ERROR$0);
                }
            }
            
            /**
             * Sets array of all "Error" element
             */
            public void setErrorArray(cl.tesoreria.sii.msgSII.MessageDocument.Message.Errores.Error[] errorArray)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    arraySetterHelper(errorArray, ERROR$0);
                }
            }
            
            /**
             * Sets ith "Error" element
             */
            public void setErrorArray(int i, cl.tesoreria.sii.msgSII.MessageDocument.Message.Errores.Error error)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    cl.tesoreria.sii.msgSII.MessageDocument.Message.Errores.Error target = null;
                    target = (cl.tesoreria.sii.msgSII.MessageDocument.Message.Errores.Error)get_store().find_element_user(ERROR$0, i);
                    if (target == null)
                    {
                      throw new IndexOutOfBoundsException();
                    }
                    target.set(error);
                }
            }
            
            /**
             * Inserts and returns a new empty value (as xml) as the ith "Error" element
             */
            public cl.tesoreria.sii.msgSII.MessageDocument.Message.Errores.Error insertNewError(int i)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    cl.tesoreria.sii.msgSII.MessageDocument.Message.Errores.Error target = null;
                    target = (cl.tesoreria.sii.msgSII.MessageDocument.Message.Errores.Error)get_store().insert_element_user(ERROR$0, i);
                    return target;
                }
            }
            
            /**
             * Appends and returns a new empty value (as xml) as the last "Error" element
             */
            public cl.tesoreria.sii.msgSII.MessageDocument.Message.Errores.Error addNewError()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    cl.tesoreria.sii.msgSII.MessageDocument.Message.Errores.Error target = null;
                    target = (cl.tesoreria.sii.msgSII.MessageDocument.Message.Errores.Error)get_store().add_element_user(ERROR$0);
                    return target;
                }
            }
            
            /**
             * Removes the ith "Error" element
             */
            public void removeError(int i)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    get_store().remove_element(ERROR$0, i);
                }
            }
            /**
             * An XML Error(@http://tesoreria.cl/sii/MsgSII.xsd).
             *
             * This is a complex type.
             */
            public static class ErrorImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements cl.tesoreria.sii.msgSII.MessageDocument.Message.Errores.Error
            {
                
                public ErrorImpl(org.apache.xmlbeans.SchemaType sType)
                {
                    super(sType);
                }
                
                private static final javax.xml.namespace.QName ERRORNRO$0 = 
                    new javax.xml.namespace.QName("http://tesoreria.cl/sii/MsgSII.xsd", "ErrorNro");
                private static final javax.xml.namespace.QName FORMULARIO$2 = 
                    new javax.xml.namespace.QName("http://tesoreria.cl/sii/MsgSII.xsd", "Formulario");
                private static final javax.xml.namespace.QName CODIGO$4 = 
                    new javax.xml.namespace.QName("http://tesoreria.cl/sii/MsgSII.xsd", "Codigo");
                private static final javax.xml.namespace.QName CONTENIDO$6 = 
                    new javax.xml.namespace.QName("http://tesoreria.cl/sii/MsgSII.xsd", "Contenido");
                private static final javax.xml.namespace.QName GLOSA$8 = 
                    new javax.xml.namespace.QName("http://tesoreria.cl/sii/MsgSII.xsd", "Glosa");
                
                
                /**
                 * Gets the "ErrorNro" element
                 */
                public java.math.BigDecimal getErrorNro()
                {
                    synchronized (monitor())
                    {
                      check_orphaned();
                      org.apache.xmlbeans.SimpleValue target = null;
                      target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ERRORNRO$0, 0);
                      if (target == null)
                      {
                        return null;
                      }
                      return target.getBigDecimalValue();
                    }
                }
                
                /**
                 * Gets (as xml) the "ErrorNro" element
                 */
                public org.apache.xmlbeans.XmlDecimal xgetErrorNro()
                {
                    synchronized (monitor())
                    {
                      check_orphaned();
                      org.apache.xmlbeans.XmlDecimal target = null;
                      target = (org.apache.xmlbeans.XmlDecimal)get_store().find_element_user(ERRORNRO$0, 0);
                      return target;
                    }
                }
                
                /**
                 * Sets the "ErrorNro" element
                 */
                public void setErrorNro(java.math.BigDecimal errorNro)
                {
                    synchronized (monitor())
                    {
                      check_orphaned();
                      org.apache.xmlbeans.SimpleValue target = null;
                      target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ERRORNRO$0, 0);
                      if (target == null)
                      {
                        target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ERRORNRO$0);
                      }
                      target.setBigDecimalValue(errorNro);
                    }
                }
                
                /**
                 * Sets (as xml) the "ErrorNro" element
                 */
                public void xsetErrorNro(org.apache.xmlbeans.XmlDecimal errorNro)
                {
                    synchronized (monitor())
                    {
                      check_orphaned();
                      org.apache.xmlbeans.XmlDecimal target = null;
                      target = (org.apache.xmlbeans.XmlDecimal)get_store().find_element_user(ERRORNRO$0, 0);
                      if (target == null)
                      {
                        target = (org.apache.xmlbeans.XmlDecimal)get_store().add_element_user(ERRORNRO$0);
                      }
                      target.set(errorNro);
                    }
                }
                
                /**
                 * Gets the "Formulario" element
                 */
                public java.math.BigDecimal getFormulario()
                {
                    synchronized (monitor())
                    {
                      check_orphaned();
                      org.apache.xmlbeans.SimpleValue target = null;
                      target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FORMULARIO$2, 0);
                      if (target == null)
                      {
                        return null;
                      }
                      return target.getBigDecimalValue();
                    }
                }
                
                /**
                 * Gets (as xml) the "Formulario" element
                 */
                public org.apache.xmlbeans.XmlDecimal xgetFormulario()
                {
                    synchronized (monitor())
                    {
                      check_orphaned();
                      org.apache.xmlbeans.XmlDecimal target = null;
                      target = (org.apache.xmlbeans.XmlDecimal)get_store().find_element_user(FORMULARIO$2, 0);
                      return target;
                    }
                }
                
                /**
                 * Sets the "Formulario" element
                 */
                public void setFormulario(java.math.BigDecimal formulario)
                {
                    synchronized (monitor())
                    {
                      check_orphaned();
                      org.apache.xmlbeans.SimpleValue target = null;
                      target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FORMULARIO$2, 0);
                      if (target == null)
                      {
                        target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(FORMULARIO$2);
                      }
                      target.setBigDecimalValue(formulario);
                    }
                }
                
                /**
                 * Sets (as xml) the "Formulario" element
                 */
                public void xsetFormulario(org.apache.xmlbeans.XmlDecimal formulario)
                {
                    synchronized (monitor())
                    {
                      check_orphaned();
                      org.apache.xmlbeans.XmlDecimal target = null;
                      target = (org.apache.xmlbeans.XmlDecimal)get_store().find_element_user(FORMULARIO$2, 0);
                      if (target == null)
                      {
                        target = (org.apache.xmlbeans.XmlDecimal)get_store().add_element_user(FORMULARIO$2);
                      }
                      target.set(formulario);
                    }
                }
                
                /**
                 * Gets the "Codigo" element
                 */
                public java.lang.String getCodigo()
                {
                    synchronized (monitor())
                    {
                      check_orphaned();
                      org.apache.xmlbeans.SimpleValue target = null;
                      target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CODIGO$4, 0);
                      if (target == null)
                      {
                        return null;
                      }
                      return target.getStringValue();
                    }
                }
                
                /**
                 * Gets (as xml) the "Codigo" element
                 */
                public org.apache.xmlbeans.XmlString xgetCodigo()
                {
                    synchronized (monitor())
                    {
                      check_orphaned();
                      org.apache.xmlbeans.XmlString target = null;
                      target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(CODIGO$4, 0);
                      return target;
                    }
                }
                
                /**
                 * Sets the "Codigo" element
                 */
                public void setCodigo(java.lang.String codigo)
                {
                    synchronized (monitor())
                    {
                      check_orphaned();
                      org.apache.xmlbeans.SimpleValue target = null;
                      target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CODIGO$4, 0);
                      if (target == null)
                      {
                        target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(CODIGO$4);
                      }
                      target.setStringValue(codigo);
                    }
                }
                
                /**
                 * Sets (as xml) the "Codigo" element
                 */
                public void xsetCodigo(org.apache.xmlbeans.XmlString codigo)
                {
                    synchronized (monitor())
                    {
                      check_orphaned();
                      org.apache.xmlbeans.XmlString target = null;
                      target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(CODIGO$4, 0);
                      if (target == null)
                      {
                        target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(CODIGO$4);
                      }
                      target.set(codigo);
                    }
                }
                
                /**
                 * Gets the "Contenido" element
                 */
                public java.lang.String getContenido()
                {
                    synchronized (monitor())
                    {
                      check_orphaned();
                      org.apache.xmlbeans.SimpleValue target = null;
                      target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CONTENIDO$6, 0);
                      if (target == null)
                      {
                        return null;
                      }
                      return target.getStringValue();
                    }
                }
                
                /**
                 * Gets (as xml) the "Contenido" element
                 */
                public org.apache.xmlbeans.XmlString xgetContenido()
                {
                    synchronized (monitor())
                    {
                      check_orphaned();
                      org.apache.xmlbeans.XmlString target = null;
                      target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(CONTENIDO$6, 0);
                      return target;
                    }
                }
                
                /**
                 * Sets the "Contenido" element
                 */
                public void setContenido(java.lang.String contenido)
                {
                    synchronized (monitor())
                    {
                      check_orphaned();
                      org.apache.xmlbeans.SimpleValue target = null;
                      target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CONTENIDO$6, 0);
                      if (target == null)
                      {
                        target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(CONTENIDO$6);
                      }
                      target.setStringValue(contenido);
                    }
                }
                
                /**
                 * Sets (as xml) the "Contenido" element
                 */
                public void xsetContenido(org.apache.xmlbeans.XmlString contenido)
                {
                    synchronized (monitor())
                    {
                      check_orphaned();
                      org.apache.xmlbeans.XmlString target = null;
                      target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(CONTENIDO$6, 0);
                      if (target == null)
                      {
                        target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(CONTENIDO$6);
                      }
                      target.set(contenido);
                    }
                }
                
                /**
                 * Gets the "Glosa" element
                 */
                public java.lang.String getGlosa()
                {
                    synchronized (monitor())
                    {
                      check_orphaned();
                      org.apache.xmlbeans.SimpleValue target = null;
                      target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(GLOSA$8, 0);
                      if (target == null)
                      {
                        return null;
                      }
                      return target.getStringValue();
                    }
                }
                
                /**
                 * Gets (as xml) the "Glosa" element
                 */
                public org.apache.xmlbeans.XmlString xgetGlosa()
                {
                    synchronized (monitor())
                    {
                      check_orphaned();
                      org.apache.xmlbeans.XmlString target = null;
                      target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(GLOSA$8, 0);
                      return target;
                    }
                }
                
                /**
                 * Sets the "Glosa" element
                 */
                public void setGlosa(java.lang.String glosa)
                {
                    synchronized (monitor())
                    {
                      check_orphaned();
                      org.apache.xmlbeans.SimpleValue target = null;
                      target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(GLOSA$8, 0);
                      if (target == null)
                      {
                        target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(GLOSA$8);
                      }
                      target.setStringValue(glosa);
                    }
                }
                
                /**
                 * Sets (as xml) the "Glosa" element
                 */
                public void xsetGlosa(org.apache.xmlbeans.XmlString glosa)
                {
                    synchronized (monitor())
                    {
                      check_orphaned();
                      org.apache.xmlbeans.XmlString target = null;
                      target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(GLOSA$8, 0);
                      if (target == null)
                      {
                        target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(GLOSA$8);
                      }
                      target.set(glosa);
                    }
                }
            }
        }
    }
}
