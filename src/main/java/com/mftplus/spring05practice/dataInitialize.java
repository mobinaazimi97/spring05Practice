package com.mftplus.spring05practice;

import com.mftplus.spring05practice.permission.Permission;
import com.mftplus.spring05practice.permission.PermissionService;
import com.mftplus.spring05practice.role.Role;
import com.mftplus.spring05practice.role.RoleService;
import com.mftplus.spring05practice.user.User;
import com.mftplus.spring05practice.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
@Slf4j
public class dataInitialize implements CommandLineRunner {
    private final PermissionService permissionService;
    private final RoleService roleService;
    private final UserService userService;

    public dataInitialize(PermissionService permissionService, RoleService roleService, UserService userService) {
        this.permissionService = permissionService;
        this.roleService = roleService;
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        Permission permission = Permission.builder().permissionName("ADMIN_Allow").build();
        permissionService.save(permission);
        Permission permission1 = Permission.builder().permissionName("CUSTOMER_ALLOW").build();
        permissionService.save(permission1);
        Permission permission2 = Permission.builder().permissionName("MANAGER_ALLOW").build();
        permissionService.save(permission2);
        Permission permission3 = Permission.builder().permissionName("ADMIN_ACCESS_HR_REPORT").build();
        permissionService.save(permission3);


        Role role = Role.builder().name("ROLE_ADMIN_WEB").permissionSet(Set.of(permission)).build();
        roleService.save(role);
//        log.info("Initialize role",roleService.findAll());
        Role role1 = Role.builder().name("ROLE_CUSTOMER").permissionSet(Set.of(permission1)).build();
        roleService.save(role1);
//        log.info("Initialize role1",roleService.findAll());
        Role role2 = Role.builder().name("ROLE_MANAGER").permissionSet(Set.of(permission2)).build();
        roleService.save(role2);
//        log.info("Initialize role2",roleService.findAll());
        Role role3 = Role.builder().name("ROLE_ADMIN").permissionSet(Set.of(permission3)).build();
        roleService.save(role3);
        log.info("Initialize roles {}",roleService.findAll());


        User user1 = User.builder()
                .username("aa")
                .password("a123")
                .roleSet(Set.of(role))
                .build();
//        userService.save(user1);
//        log.info("user1 added{}", userService.save(user1));

        User user2 = User.builder()
                .username("bb")
                .password("b321")
                .roleSet(Set.of(role1))
                .build();
//        userService.save(user2);
//        log.info("user2 added {}", userService.save(user2));


        User user3 = User.builder()
                .username("cc")
                .password("c45")
                .roleSet(Set.of(role2))
                .build();
//        userService.save(user3);
//        log.info("user3 added {}", userService.save(user3));

        User user4 = User.builder()
                .username("user")
                .password("us5")
                .roleSet(Set.of(role3))
                .build();
//        userService.save(user4);
//        log.info("user4 added {}", userService.save(user4));
//      log.info("Password Found {}",userService.findByPassword("$2a$10$m1Xpxlk2dcRNd5jjksKeYOkcbq09NZTyActxUTySVTppcI6wqPLJO"));

        userService.saveAll(List.of(user1,user2,user3,user4));
        log.info("users add {}",userService.saveAll(List.of(user1,user2,user3,user4)));
//-------------------------------------------------------------------------------------------------------------------------------------------------

//        Card card = Card
//                .builder()
//                .amount(13).paymentDateTime(LocalDate.now().atStartOfDay()).deleted(true).cardNumber("6037").build();
//        Cash cash = Cash.builder().amount(34).deleted(false).customerName("bb").build();
//
//        Check check = Check.builder().checkNumber("435").paymentDateTime(LocalDate.now().atStartOfDay()).deleted(false).amount(67).build();
//
//        Invoice invoice1=Invoice.builder()
//                .invoiceDate(LocalDate.now())
//                .cardList(List.of(card))
//                .deleted(true)
//                .build();
//        invoiceService.saveOrder(invoice1);
//        log.info("invoice 1 saved : {}",invoice1);
//
//        Invoice invoice2=Invoice.builder()
//                .invoiceDate(LocalDate.now())
//                .cashList(List.of(cash))
//                .deleted(false)
//                .build();
//        invoiceService.saveOrder(invoice2);
//        log.info("invoice 2 saved : {}",invoice2);


        // Key Point In SINGLE_TABLE :
        // Save is For All Payment Method / findAll for All PaymentMethod
        // Heavy Queries / UnUsed Fields
//        Invoice invoice3 = Invoice.builder()
//                .paymentList(List.of(card, cash, check))
//                .build();
//        invoiceService.saveOrder(invoice3);
//        log.info("invoice 3 saved : {}", invoice3);
//        invoiceService.getOrderById(1L);
//        log.info("invoice 3 get order id : {}", invoice3.getId());
//        log.info("invoices {}", invoiceService.findAll());

        // When strategy = TABLE_PER_CLASS :
        // invoiceService.saveOrder(invoice) ;(invoiceService--> //saveAll(cardList) , saveAll(checkList) , saveAll(cashList)
        // find also like the save

    }
}