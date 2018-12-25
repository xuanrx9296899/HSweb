
package szxajxx;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the szxajxx package. 
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

    private final static QName _GetAllSANH_QNAME = new QName("http://webServices.dataInterface.thunisoft.com/", "getAllSANH");
    private final static QName _GetAllSANHResponse_QNAME = new QName("http://webServices.dataInterface.thunisoft.com/", "getAllSANHResponse");
    private final static QName _GetDataBySANH_QNAME = new QName("http://webServices.dataInterface.thunisoft.com/", "getDataBySANH");
    private final static QName _GetDataBySANHResponse_QNAME = new QName("http://webServices.dataInterface.thunisoft.com/", "getDataBySANHResponse");
    private final static QName _GetDataByNDH_QNAME = new QName("http://webServices.dataInterface.thunisoft.com/", "getDataByNDH");
    private final static QName _GetDataByNDHResponse_QNAME = new QName("http://webServices.dataInterface.thunisoft.com/", "getDataByNDHResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: szxajxx
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetDataByNDHResponse }
     * 
     */
    public GetDataByNDHResponse createGetDataByNDHResponse() {
        return new GetDataByNDHResponse();
    }

    /**
     * Create an instance of {@link GetDataByNDH }
     * 
     */
    public GetDataByNDH createGetDataByNDH() {
        return new GetDataByNDH();
    }

    /**
     * Create an instance of {@link GetDataBySANHResponse }
     * 
     */
    public GetDataBySANHResponse createGetDataBySANHResponse() {
        return new GetDataBySANHResponse();
    }

    /**
     * Create an instance of {@link GetAllSANHResponse }
     * 
     */
    public GetAllSANHResponse createGetAllSANHResponse() {
        return new GetAllSANHResponse();
    }

    /**
     * Create an instance of {@link GetDataBySANH }
     * 
     */
    public GetDataBySANH createGetDataBySANH() {
        return new GetDataBySANH();
    }

    /**
     * Create an instance of {@link GetAllSANH }
     * 
     */
    public GetAllSANH createGetAllSANH() {
        return new GetAllSANH();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllSANH }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.dataInterface.thunisoft.com/", name = "getAllSANH")
    public JAXBElement<GetAllSANH> createGetAllSANH(GetAllSANH value) {
        return new JAXBElement<GetAllSANH>(_GetAllSANH_QNAME, GetAllSANH.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllSANHResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.dataInterface.thunisoft.com/", name = "getAllSANHResponse")
    public JAXBElement<GetAllSANHResponse> createGetAllSANHResponse(GetAllSANHResponse value) {
        return new JAXBElement<GetAllSANHResponse>(_GetAllSANHResponse_QNAME, GetAllSANHResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDataBySANH }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.dataInterface.thunisoft.com/", name = "getDataBySANH")
    public JAXBElement<GetDataBySANH> createGetDataBySANH(GetDataBySANH value) {
        return new JAXBElement<GetDataBySANH>(_GetDataBySANH_QNAME, GetDataBySANH.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDataBySANHResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices.dataInterface.thunisoft.com/", name = "getDataBySANHResponse")
    public JAXBElement<GetDataBySANHResponse> createGetDataBySANHResponse(GetDataBySANHResponse value) {
        return new JAXBElement<GetDataBySANHResponse>(_GetDataBySANHResponse_QNAME, GetDataBySANHResponse.class, null, value);
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

}
