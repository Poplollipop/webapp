package com.bmt.webapp.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import com.bmt.webapp.models.Client;
import com.bmt.webapp.models.ClientDo;
import com.bmt.webapp.repositories.ClientRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/clients")

public class ClientsController {

	@Autowired
	private ClientRepository clientRepo;

	@GetMapping({ "", "/" })
	public String getClients(Model model) {
		var clients = clientRepo.findAll(Sort.by(Sort.Direction.DESC, "id"));
		model.addAttribute("clients", clients);
		return "clients/index";
	}

	@GetMapping("/create")
	public String createClient(Model model) {
		ClientDo clientDo = new ClientDo();
		model.addAttribute("clientDo", clientDo);

		return "clients/create";
	}

	@PostMapping("/create")
	public String createClient(@Valid @ModelAttribute ClientDo clientDo, BindingResult result) {
		if (clientRepo.findByEmail(clientDo.getEmail()) != null) {
			result.addError(new FieldError("clientDo", "email", clientDo.getEmail(), false, null, null,
					"Email address is already used"));
		}

		if (result.hasErrors()) {
			return "clients/create";
		}
		Client client = new Client();
		client.setFirstName(clientDo.getFirstName());
		client.setLastName(clientDo.getLastName());
		client.setEmail(clientDo.getEmail());
		client.setPhone(clientDo.getPhone());
		client.setAddress(clientDo.getAddress());
		client.setStatus(clientDo.getStatus());
		client.setCreatedAt(new Date());
		clientRepo.save(client);
		return "redirect:/clients";
	}

	@GetMapping("/edit")
	public String editClient(Model model, @RequestParam int id) {
		Client client = clientRepo.findById(id).orElse(null);
		if (client == null) {
			return "redirect:/clients";
		}
		ClientDo clientDo = new ClientDo();
		clientDo.setFirstName(client.getFirstName());
		clientDo.setLastName(client.getLastName());
		clientDo.setEmail(client.getEmail());
		clientDo.setPhone(client.getPhone());
		clientDo.setAddress(client.getAddress());
		clientDo.setStatus(client.getStatus());

		model.addAttribute("client", client);
		model.addAttribute("clientDo", clientDo);
		return "clients/edit";
	}

	@PostMapping("/edit")
	public String editClient(Model model, @RequestParam int id, @Valid @ModelAttribute ClientDo clientDo,
			BindingResult result) {
		// 查找客户端
		Client client = clientRepo.findById(id).orElse(null);
		if (client == null) {
			return "redirect:/clients"; // 如果未找到，重定向到客户端列表
		}

		if (result.hasErrors()) {
			model.addAttribute("client", client); // 重新加载客户端对象以便在编辑页面中显示
			return "clients/edit"; // 返回编辑页面
		}

		// 更新客户端信息
		client.setFirstName(clientDo.getFirstName());
		client.setLastName(clientDo.getLastName());
		client.setEmail(clientDo.getEmail());
		client.setPhone(clientDo.getPhone());
		client.setAddress(clientDo.getAddress());
		client.setStatus(clientDo.getStatus());

		try {
			clientRepo.save(client); // 保存更新后的客户端
		} catch (Exception ex) {
			result.addError(new FieldError("clientDo", "email", clientDo.getEmail(), false, null, null,
					"Email address is already used"));
			return "redirect:/edit?id=" + id;
		}

		return "redirect:/clients"; // 成功后重定向到客户端列表
	}
	@GetMapping("/delete")
	public String deleteClient(@RequestParam int id) {
		Client client = clientRepo.findById(id).orElse(null);
		if (client != null) {
			clientRepo.delete(client);			
		}
		return "redirect:/clients";
	}
}



