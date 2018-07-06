package weaver.interfaces.workflow.action.gx;
import java.util.HashMap;
import java.util.Map;
import weaver.conn.RecordSet;
import weaver.conn.RecordSetDataSource;
import weaver.general.BaseBean;
import weaver.general.TimeUtil;
import weaver.interfaces.workflow.action.Action;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import weaver.general.Util;
import weaver.soa.workflow.request.Cell;
import weaver.soa.workflow.request.DetailTable;
import weaver.soa.workflow.request.Property;
import weaver.soa.workflow.request.RequestInfo;
import weaver.soa.workflow.request.Row;

public class ZCGHupdate implements Action {
	public String execute(RequestInfo request) {
     RecordSet rs = new RecordSet();	
		//取主表数据
		String requestid=request.getRequestid();
		Property[] properties = request.getMainTableInfo().getProperty();// 获取表单主字段信息
		String fqr = "";
        String bm = "";
		String dw = "";
		rs.executeSql("select id from  formtable_main_32 where requestId="
				+ requestid );
				rs.next();
				String ids = Util.null2String(rs.getString("id"));

		for (int i = 0; i < properties.length; i++) {
			String name = properties[i].getName();// 主字段名称
			String value = Util.null2String(properties[i].getValue());// 主字段对应的值
			if (name.equals("field06")) {
				fqr = value;
			}
			if (name.equals("field07")) {
				bm = value;
			}
			if (name.equals("field08")) {
				dw = value;
			}
		}

		//取明细数据
		DetailTable[] detailtable = request.getDetailTableInfo()
				.getDetailTable();// 获取所有明细表

		if (detailtable.length > 0) {
			for (int i = 0; i < detailtable.length; i++) {

				DetailTable dt = detailtable[i];// 指定明细表
				Row[] s = dt.getRow();// 当前明细表的所有数据,按行存储
				for (int j = 0; j < s.length; j++) {

					Row r = s[j];// 指定行
					Cell c[] = r.getCell();// 每行数据再按列存储
					for (int k = 0; k < c.length; k++) {

						Cell c1 = c[k];// 指定列
						String name = c1.getName();// 明细字段名称
						String value = c1.getValue();// 明细字段的值
						System.out.println(name + " " + value);
			       
		    String PJ ="update formtable_main_32_dt1  set detailfield06='" + fqr + "',detailfield07='" + bm + "',detailfield08='" + dw + "' ,workrequestid='" + requestid + "',FtriggerFlag='0'  where mainid="+ids;
            System.out.println("ZCGUUUUU++++++"+PJ);
			 rs.execute(PJ);
					}
				}
			}
		}

		return Action.SUCCESS;
	}
}
