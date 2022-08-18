package com.ticketmain.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder.In;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ticketmain.dao.BusDao;
import com.ticketmain.dao.CreditCardDao;
import com.ticketmain.dao.DriverDao;
import com.ticketmain.dao.FirmDao;
import com.ticketmain.dao.TicketDao;
import com.ticketmain.dao.TripDao;
import com.ticketmain.dao.UserDao2;
import com.ticketmain.models.Bus;
import com.ticketmain.models.CreditCard;
import com.ticketmain.models.Driver;
import com.ticketmain.models.Firm;
import com.ticketmain.models.Ticket;
import com.ticketmain.models.Trip;
import com.ticketmain.models.User;
import com.ticketmain.requests.BusRequest;
import com.ticketmain.requests.CreditCardRequest;
import com.ticketmain.requests.DriverRequest;
import com.ticketmain.requests.FirmRequest;
import com.ticketmain.requests.TicketRequest;
import com.ticketmain.requests.TripRequest;
import com.ticketmain.requests.UserRequest;

@Controller
public class TicketController {

	@Autowired
	private UserDao2 dao;

	@Autowired
	private DriverDao driverDao;

	@Autowired
	private FirmDao firmDao;

	@Autowired
	private BusDao busDao;

	@Autowired
	private TripDao tripDao;

	@Autowired
	private TicketDao ticketDao;

	@Autowired
	private PasswordEncoder encoder;

	@Autowired
	private CreditCardDao cardDao;

	@GetMapping("/za")
	public String sayHello() {

		return "za";

	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/profile")
	public String profile(Model model) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		User u = this.dao.findById(user.getId());

		if (u.getRole() == 0) {
			model.addAttribute("user", u);
			return "admin";
		} else {
			model.addAttribute("user", u);
			return "user";
		}

	}

	@PostMapping("/driveradd")
	public String save(@Valid DriverRequest request, Model model) {
		Driver d = new Driver();
		d.setName(request.getName());
		d.setSurname(request.getSurname());

		this.driverDao.save(d);

		List<Driver> drivers = this.driverDao.findAll();

		model.addAttribute("drivers", drivers);

		return "drivers";

	}

	@GetMapping("/driverView")
	public String driverView() {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		User u = this.dao.findById(user.getId());

		if (u.getRole() == 1) {
			return "failed";
		}

		return "add";
	}

	@GetMapping("/firmView")
	public String firmView(Model model) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		User u = this.dao.findById(user.getId());

		if (u.getRole() == 1) {
			return "failed";
		}

		model.getAttribute("drivers");

		return "addfirm";
	}

	@PostMapping("/firmadd")
	public String save2(@Valid FirmRequest firmRequest, Model model) {

		Firm f = new Firm();
		f.setName(firmRequest.getName());
		f.setFounderName(firmRequest.getFounderName());

		this.firmDao.save(f);

		List<Firm> firms = this.firmDao.findAll();

		model.addAttribute("firms", firms);

		return "firms";

	}

	@GetMapping("/busView")
	public String busView(Model model) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		User u = this.dao.findById(user.getId());

		if (u.getRole() == 1) {
			return "failed";
		}

		List<Driver> drivers = this.driverDao.findAll();
		List<Firm> firms = this.firmDao.findAll();

		model.addAttribute("driver", drivers);
		model.addAttribute("firm", firms);

		return "addbus";

	}

	@PostMapping("/busadd")
	public String save3(@Valid BusRequest busRequest, Model model) {

		int driverid = Integer.valueOf(busRequest.getDriverid());
		int firmid = Integer.valueOf(busRequest.getFirmid());

		System.out.println(firmid);

		Firm f = (Firm) this.firmDao.findById(firmid);
		Driver d = (Driver) this.driverDao.findById(driverid);

		Bus b = new Bus();

		b.setName(busRequest.getName());
		b.setCapacity(busRequest.getCapacity());
		b.setDriver(d);
		b.setFirm(f);
		b.setDriverid(driverid);
		b.setFirmid(firmid);

		this.busDao.save(b);

		List<Bus> buses = this.busDao.findAll();

		model.addAttribute("buses", buses);

		return "buses";

	}

	@GetMapping("/tripView")
	public String tripView(Model model) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		User u = this.dao.findById(user.getId());

		if (u.getRole() == 1) {
			return "failed";
		}

		List<Bus> buses = this.busDao.findAll();

		model.addAttribute("buses", buses);

		return "addtrip";
	}

	@PostMapping("/tripadd")
	public String save4(@Valid TripRequest tripRequest, BindingResult rs, RedirectAttributes ra, Model model) {

		int busId = Integer.valueOf(tripRequest.getBusid());
		int price = Integer.valueOf(tripRequest.getPrice());

		Trip t = new Trip();

		Bus b = (Bus) this.busDao.getById(busId);

		t.setBus(b);
		t.setTrip_name(tripRequest.getTrip_name());
		t.setDestination(tripRequest.getDestination());
		t.setStarting_spot(tripRequest.getStarting_spot());
		t.setStarting_date(tripRequest.getStarting_date());
		t.setBusid(busId);
		t.setPrice(price);

		this.tripDao.save(t);

		List<Trip> trips = this.tripDao.findAll();
		model.addAttribute("trips", trips);

		if (rs.hasErrors()) {
			HashMap<String, String> errors = new HashMap<String, String>();
			for (FieldError r : rs.getFieldErrors()) {
				errors.put(r.getField(), r.getDefaultMessage());
			}
			ra.addFlashAttribute("errors", errors);
			return "addtrip";
		}

		return "trips";

	}

	@GetMapping("/registerView")
	public String registerView() {

		return "register";
	}

	@PostMapping("/registers")
	public String save5(@Valid UserRequest request) {

		User u = new User();

		u.setName(request.getName());
		u.setSurname(request.getSurname());
		u.setEmail(request.getEmail());
		u.setPassword(encoder.encode(request.getPassword()));
		u.setBalance(1000);
		u.setRole(1);

		this.dao.save(u);

		return "login";

	}

	@GetMapping("/busesView")
	public String busesView(Model model) {
		List<Bus> buses = this.busDao.findAll();

		model.addAttribute("buses", buses);

		return "buses";

	}

	@GetMapping("/firmsView")
	public String firmsView(Model model) {

		List<Firm> firms = this.firmDao.findAll();

		model.addAttribute("firms", firms);

		return "firms";

	}

	@GetMapping("/driversView")
	public String driversView(Model model) {

		List<Driver> drivers = this.driverDao.findAll();
		model.addAttribute("drivers", drivers);

		return "drivers";

	}

	@GetMapping("/tripsView")
	public String tripsView(Model model) {

		List<Trip> trips = this.tripDao.findAll();
		model.addAttribute("trips", trips);

		return "trips";

	}

	@GetMapping("/ticketView")
	public String ticketView(Model model) {

		List<Trip> trips = this.tripDao.findAll();
		model.addAttribute("trips", trips);

		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		User u = this.dao.findById(user.getId());

		List<CreditCard> cards = u.getCards();

		model.addAttribute("cards", cards);

		return "addticket";

	}

	@PostMapping("/ticketadd")
	public String save6(@Valid TicketRequest ticketRequest, Model model) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		User u = this.dao.findById(user.getId());

		Ticket t = new Ticket();

		int tripid = Integer.valueOf(ticketRequest.getTripid());

		Trip trip = this.tripDao.getById(tripid);

		t.setPassengername(u.getName());
		t.setPassengersurname(u.getSurname());
		t.setTrip(trip);
		t.setTripid(tripid);
		t.setTripname(trip.getTrip_name());
		t.setPurchasetime(ticketRequest.getPurchase_time());
		t.setPrice(trip.getPrice());
		t.setUser(u);
		t.setTripdate(trip.getStarting_date());

		if (ticketRequest.getPayment().equals("balance")) {
			if (u.getBalance() >= trip.getPrice()) {
				u.setBalance(u.getBalance() - trip.getPrice());
				this.dao.save(u);
				this.ticketDao.save(t);
			} else {
				return "failedd";
			}
		} else {

			int id = Integer.valueOf(ticketRequest.getPayment());

			CreditCard c = this.cardDao.getById(id);

			if (c.getBalance() >= trip.getPrice()) {
				c.setBalance(c.getBalance() - trip.getPrice());
				this.dao.save(u);
				this.ticketDao.save(t);
			} else {
				return "failedd";
			}

		}

		List<Ticket> tickets = new ArrayList<Ticket>();
		tickets.add(t);

		u.setTicket(tickets);

		List<Ticket> ticketske = u.getTicket();

		model.addAttribute("tickets", ticketske);

		return "tickets";

	}

	@GetMapping("/ticketsView")
	public String ticketsView(Model model) {

		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		User u = this.dao.findById(user.getId());

		List<Ticket> ticketske = u.getTicket();
		model.addAttribute("tickets", ticketske);
		return "tickets";

	}

	@GetMapping("/deldriverView")
	public String delView(Model model) {
		List<Driver> drivers = this.driverDao.findAll();
		model.addAttribute("drivers", drivers);
		return "deldriver";

	}

	@PostMapping("/driverdelete")
	public String del(@Valid DriverRequest request, Model model) {

		int id = Integer.valueOf(request.getId());

		Driver d = this.driverDao.getById(id);

		this.driverDao.delete(d);
		List<Driver> drivers = this.driverDao.findAll();
		model.addAttribute("drivers", drivers);

		return "drivers";

	}

	@GetMapping("/delfirmView")
	public String delView2(Model model) {

		List<Firm> firms = this.firmDao.findAll();
		model.addAttribute("firms", firms);
		return "delfirm";

	}

	@PostMapping("/firmdelete")
	public String del2(@Valid FirmRequest request, Model model) {
		int id = Integer.valueOf(request.getId());
		Firm f = this.firmDao.getById(id);
		this.firmDao.delete(f);

		List<Firm> firms = this.firmDao.findAll();
		model.addAttribute("firms", firms);

		return "firms";

	}

	@GetMapping("/delbusView")
	public String delView3(Model model) {
		List<Bus> buses = this.busDao.findAll();
		model.addAttribute("buses", buses);

		return "delbus";

	}

	@PostMapping("/busdelete")
	public String del3(@Valid BusRequest request, Model model) {

		int id = Integer.valueOf(request.getId());
		Bus b = this.busDao.getById(id);
		this.busDao.delete(b);

		List<Bus> buses = this.busDao.findAll();
		model.addAttribute("buses", buses);

		return "buses";

	}

	@GetMapping("/deltripView")
	public String delView4(Model model) {
		List<Trip> trips = this.tripDao.findAll();
		model.addAttribute("trips", trips);
		return "deltrip";

	}

	@PostMapping("/tripdelete")
	public String del4(@Valid TripRequest request, Model model) {

		int id = Integer.valueOf(request.getId());
		Trip t = this.tripDao.getById(id);
		this.tripDao.delete(t);

		List<Trip> trips = this.tripDao.findAll();
		model.addAttribute("trips", trips);

		return "trips";
	}

	@GetMapping("/delticketView")
	public String delView5(Model model) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		User u = this.dao.findById(user.getId());

		List<Ticket> tickets = u.getTicket();

		model.addAttribute("tickets", tickets);

		return "delticket";

	}

	@PostMapping("ticketdelete")
	public String delticket(@Valid TicketRequest request, Model model) {

		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		User u = this.dao.findById(user.getId());

		int id = Integer.valueOf(request.getId());

		Ticket t = this.ticketDao.getById(id);

		u.setBalance(u.getBalance() + t.getPrice());

		this.ticketDao.delete(t);

		List<Ticket> tickets = u.getTicket();

		model.addAttribute("tickets", tickets);

		return "tickets2";

	}

	@GetMapping("/cardView")
	public String cardView() {

		return "addcard";

	}

	@PostMapping("/cardadd")
	public String save7(@Valid CreditCardRequest request, Model model) {

		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		User u = this.dao.findById(user.getId());

		CreditCard c = new CreditCard();

		int cvv = Integer.valueOf(request.getCvv());

		c.setAddress(request.getAddress());
		c.setBalance(10000);
		c.setCardnumber(request.getCardnumber());
		c.setCountry(request.getCountry());
		c.setCvv(cvv);
		c.setExp(request.getExp());
		c.setName(request.getName());
		c.setNetwork(request.getNetwork());
		c.setUser(u);

		this.cardDao.save(c);

		u.getCards().add(c);

		this.dao.save(u);

		List<CreditCard> cards = u.getCards();

		model.addAttribute("cards", cards);

		return "cards";

	}

	@GetMapping("/cardsView")
	public String cardsView(Model model) {

		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		User u = this.dao.findById(user.getId());

		List<CreditCard> cards = u.getCards();

		model.addAttribute("cards", cards);

		return "cards";

	}

	@GetMapping("/moneyView")
	public String moneyView(Model model) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		User u = this.dao.findById(user.getId());

		List<CreditCard> cards = u.getCards();

		model.addAttribute("cards", cards);

		return "addmoney";

	}

	@PostMapping("/moneyadd")
	public String save9(@Valid CreditCardRequest request, Model model) {

		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		User u = this.dao.findById(user.getId());

		int id = Integer.valueOf(request.getId());

		int money = Integer.valueOf(request.getMoney());

		CreditCard c = this.cardDao.getById(id);

		if (c.getBalance() >= money) {
			c.setBalance(c.getBalance() - money);
			u.setBalance(u.getBalance() + money);

			this.dao.save(u);
			this.cardDao.save(c);

			model.addAttribute("user", u);

			return "user";

		}

		return "failedd";

	}

	@GetMapping("/delcardView")
	private String delcardView(Model model) {

		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		User u = this.dao.findById(user.getId());

		List<CreditCard> cards = u.getCards();

		model.addAttribute("cards", cards);

		return "delcard";

	}

	@PostMapping("/carddelete")
	private String delcard(@Valid CreditCardRequest request, Model model) {

		int id = Integer.valueOf(request.getId());

		CreditCard c = this.cardDao.getById(id);

		this.cardDao.delete(c);

		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		User u = this.dao.findById(user.getId());

		List<CreditCard> cards = u.getCards();

		model.addAttribute("cards", cards);

		return "cards";

	}

}
