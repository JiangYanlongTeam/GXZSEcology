package weaver.interfaces.gx.jyl.extension.tzgl.Mode;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

@XmlRootElement(name="INPUT")
@XmlType(propOrder = {"HEADER","LINE"})
public class JTCLFBXCreateModel_YYGS {

	public JTCLFBXCreateModel_YYGS(){}

	public JTCLFBXCreateModel_YYGS(List<JTCLFBXCreate_HeadModel> hEADER,
                                   List<JTCLFBXCreate_ItemModel_YYGS> lINE) {
		super();
		HEADER = hEADER;
		LINE = lINE;
	}

	private List<JTCLFBXCreate_HeadModel> HEADER;
	private List<JTCLFBXCreate_ItemModel_YYGS> LINE;

	@XmlElement(name="HEADER")
	public List<JTCLFBXCreate_HeadModel> getHEADER() {
		return HEADER;
	}
	public void setHEADER(List<JTCLFBXCreate_HeadModel> hEADER) {
		HEADER = hEADER;
	}
	@XmlElementWrapper(name="LINES")
	@XmlElement(name="LINE")
	public List<JTCLFBXCreate_ItemModel_YYGS> getLINE() {
		return LINE;
	}
	public void setLINE(List<JTCLFBXCreate_ItemModel_YYGS> lINE) {
		LINE = lINE;
	}
}
