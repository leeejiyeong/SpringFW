package co.micol.prj.shop.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.micol.prj.shop.map.ShopMapper;
import co.micol.prj.shop.vo.ShopCustomerVO;
import co.micol.prj.shop.vo.ShopMemberVO;
import co.micol.prj.shop.vo.ShopUserVO;

@Service
public class ShopServiceImpl implements ShopService {
	
	@Autowired
	private ShopMapper mapper;

	@Override
	public List<Map<String, Object>> getCustomerList() {
		return mapper.getCustomerList();
	}
	
	@Override
	public List<ShopCustomerVO> getCustomerList2() {		//객체타입으로
		return mapper.getCustomerList2();
	}

	@Override
	public List<ShopUserVO> getShopList() {
		return mapper.getShopList();
	}

	@Override
	public ShopMemberVO loginCheck(ShopMemberVO vo) {
		return mapper.loginCheck(vo);
	}

	@Override
	public boolean isIdCheck(String id) {
		return mapper.isIdCheck(id);
	}

	@Override
	public int setShopUser(ShopUserVO vo) {
		return mapper.setShopUser(vo);
	}

	@Override
	public int setCustomer(ShopCustomerVO vo) {
		return mapper.setCustomer(vo);
	}

	@Override
	public int setMember(ShopMemberVO vo) {
		return mapper.setMember(vo);
	}

}
