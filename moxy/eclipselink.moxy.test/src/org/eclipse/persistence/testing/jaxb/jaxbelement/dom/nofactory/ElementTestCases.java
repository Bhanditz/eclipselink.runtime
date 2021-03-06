/*******************************************************************************
 * Copyright (c) 1998, 2012 Oracle and/or its affiliates. All rights reserved.
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License v1.0 and Eclipse Distribution License v. 1.0 
 * which accompanies this distribution. 
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at 
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * Contributors:
 *     Denise Smith - October 2012
 ******************************************************************************/ 
package org.eclipse.persistence.testing.jaxb.jaxbelement.dom.nofactory;

import javax.print.Doc;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilderFactory;

import org.eclipse.persistence.oxm.XMLConstants;
import org.eclipse.persistence.testing.jaxb.JAXBWithJSONTestCases;
import org.eclipse.persistence.testing.jaxb.jaxbelement.dom.ObjectFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class ElementTestCases extends JAXBWithJSONTestCases{

    private final static String XML_RESOURCE_ORIGINAL = "org/eclipse/persistence/testing/jaxb/jaxbelement/dom/nofactory/element_original.xml";
    private final static String XML_RESOURCE = "org/eclipse/persistence/testing/jaxb/jaxbelement/dom/nofactory/element.xml";
    private final static String JSON_RESOURCE = "org/eclipse/persistence/testing/jaxb/jaxbelement/dom/nofactory/element.json";

    public ElementTestCases(String name) throws Exception {
        super(name);
        setClasses(new Class[]{});
        setControlDocument(XML_RESOURCE);
        setControlJSON(JSON_RESOURCE);
    }

    @Override
    protected Object getControlObject() {       
        Document doc;
        try {     
            doc = parser.parse(this.getClass().getClassLoader().getResourceAsStream(XML_RESOURCE_ORIGINAL));            
            JAXBElement  obj = new JAXBElement<Object>(new QName("mynamespace", "mynewname"), Object.class, doc.getDocumentElement());
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
            fail("An exception was thrown.");            
            return null;
        }
    }
    
    public boolean isUnmarshalTest(){
        return false;
    }
    
}
