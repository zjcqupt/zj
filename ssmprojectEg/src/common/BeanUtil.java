package common;

import java.util.List;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.zj.entities.User;
/*
 * �����ת��Ϊ��װ�õ�PageResult��
 * ����PageHelper��page��ʵ��
 * ��������controller���Ѿ�����ͨ��pageInfoת��Ϊ��װ��
 * ֻ�ǰѹ�����ת�ƹ���
 */
public class BeanUtil {
	private BeanUtil() {
		// �����๹�캯��˽�л�
	}
	@SuppressWarnings("unchecked")
	public static <T> PagedResult<T> toPagedResult(List<T> datas,PageInfo<User> userList) {
        PagedResult<T> result = new PagedResult<T>();
        if (datas instanceof Page) {
            @SuppressWarnings("rawtypes")
			Page page = (Page) datas;
            result.setPageNo(page.getPageNum());
            result.setPageSize(page.getPageSize());
            result.setDataList(page.getResult());
            result.setTotal(page.getTotal());
            result.setPages(page.getPages());
            //��һ�����Ʒ�װ��
            result.setFirstPage(userList.getFirstPage());
            result.setLastPage(userList.getLastPage());
            result.setNextPage(page.getPageNum()+1);
            result.setPrePage(page.getPageNum()-1);
            result.setNavigatepageNums(userList.getNavigatepageNums());
        }
        else {
            result.setPageNo(1);
            result.setPageSize(datas.size());
            result.setDataList(datas);
            result.setTotal(datas.size());
        }

        return result;
    }

	
}
