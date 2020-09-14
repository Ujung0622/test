package com.spring.mvc.ex02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.mvc.ex02.component.AclModRequest;

@Controller
public class ACLController {
	@Autowired
	private AclService aclService;

	@RequestMapping("/acl/list")
	public String list(Model model) {
		System.out.println("ACLController list");
		model.addAttribute("aclList", aclService.getAclList());
		return "acl/aclList";
	}

	@RequestMapping("/acl/modify")
	public String modify(AclModRequest modReq) {
		System.out.println("ACLController modify");
		/*
		List<AccessPerm> perms = new ArrayList<>();
		for (AccessPerm reqPerm : modReq.getPerms())
			if (reqPerm.hasData())
				perms.add(reqPerm);
		modReq.setPerms(perms);
		*/
		aclService.modifyAccessControll(modReq);
		return "redirect:/acl/list";
	}

	public void setAclService(AclService aclService) {
System.out.println("ACLController setAclService");
		this.aclService = aclService;
	}

}
