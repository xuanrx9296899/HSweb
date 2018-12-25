
package spajxx;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the spajxx package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetAllNDH_QNAME = new QName("http://webServices.dataInterface.thunisoft.com/", "getAllNDH");
    private final static QName _GetDataByNDH_QNAME = new QName("http://webServices.dataInterface.thunisoft.com/", "getDataByNDH");
    private final static QName _GetDataByNDHResponse_QNAME = new QName("http://webServices.dataInterface.thunisoft.com/", "getDataByNDHResponse");
    private final static QName _GetAllNDHResponse_QNAME = new QName("http://webServices.dataInterface.thunisoft.com/", "getAllNDHResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: spajxx
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetAllNDHResponse }
     * 
     */
    public GetAllNDHResponse createGetAllNDHResponse() {
        return new GetAllNDHResponse();
    }

    /**
     * Create an instance of {@link GetDataByNDHResponse }
     * 
     */
    public GetDataByNDHResponse createGetDataByNDHResponse() {
        return new GetDataByNDHResponse();
    }

    /**
     * Create an instance of {@link GetAllNDH }
     * 
     */
    public GetAllNDH createGetAllNDH() {
        return new GetAllNDH();
    }

    /**
     * Create an instance of {@link GetDataByNDH }
     * 
     */
    public GetDataByNDH createGetDataByNDH() {
        return new GetDataByNDH();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllNDH }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.dataInterface.thunisoft.com/", name = "getAllNDH")
    public JAXBElement<GetAllNDH> createGetAllNDH(GetAllNDH value) {
        return new JAXBElement<GetAllNDH>(_GetAllNDH_QNAME, GetAllNDH.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDataByNDH }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.dataInterface.thunisoft.com/", name = "getDataByNDH")
    public JAXBElement<GetDataByNDH> createGetDataByNDH(GetDataByNDH value) {
        return new JAXBElement<GetDataByNDH>(_GetDataByNDH_QNAME, GetDataByNDH.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDataByNDHResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.dataInterface.thunisoft.com/", name = "getDataByNDHResponse")
    public JAXBElement<GetDataByNDHResponse> createGetDataByNDHResponse(GetDataByNDHResponse value) {
        return new JAXBElement<GetDataByNDHResponse>(_GetDataByNDHResponse_QNAME, GetDataByNDHResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllNDHResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.dataInterface.thunisoft.com/", name = "getAllNDHResponse")
    public JAXBElement<GetAllNDHResponse> createGetAllNDHResponse(GetAllNDHResponse value) {
        return new JAXBElement<GetAllNDHResponse>(_GetAllNDHResponse_QNAME, GetAllNDHResponse.class, null, value);
    }

}
