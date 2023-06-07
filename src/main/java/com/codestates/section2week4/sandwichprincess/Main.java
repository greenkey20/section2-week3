package com.codestates.section2week4.sandwichprincess;
// 자바에서는 원칙적으로 default 패키지의 클래스들을 다른 클래스에서 import 할 수 없음 -> 다른 클래스에서 사용할 예정이라면 클래스들을 일단 하나의 패키지 안에 포함시켜주는 것이 좋음

import com.codestates.section2week4.sandwichprincess.common.AppConfigurer;
import com.codestates.section2week4.sandwichprincess.order.Cart;
import com.codestates.section2week4.sandwichprincess.order.Order;
import com.codestates.section2week4.sandwichprincess.order.OrderApp;
import com.codestates.section2week4.sandwichprincess.product.Menu;
import com.codestates.section2week4.sandwichprincess.product.ProductRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// 2023.5.11(목) 22h20 oop 심화 실습 -> 2023.5.21(일) 23h40 Spring framework 사용해서 전환
public class Main {
    public static void main(String[] args) {
        /*
        AppConfigurer appConfigurer = new AppConfigurer();
        OrderApp orderApp = new OrderApp(
                appConfigurer.productRepository(),
                appConfigurer.menu(),
                appConfigurer.cart(), // 2023.5.16(화) 11h55 현재 여기서 할당되는 Cart 인스턴스와
                appConfigurer.order() // 여기서 할당되는 Cart 인스턴스가 다름 -> 주문 시 장바구니 내역이 보이지 않음
        );
         */

        // Spring 컨테이너 생성 및 초기화 <- 클래스 구성 정보를 매개변수로 받음
        // close() 메서드 사용하려면 AnnotationConfigApplicationContext 자료형으로 객체 생성해야 함
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfigurer.class);

        // Spring 컨테이너는 클래스 구성 정보를 바탕으로 Bean 객체들 생성 + 객체들 간의 의존 관계 연결 = Spring 설정 작업

        // Spring Bean 조회 = 필요한 객체/Spring Bean을 필요할 때마다 Spring 컨테이너에서 불러 사용함
        ProductRepository productRepository = applicationContext.getBean("productRepository", ProductRepository.class);
        Menu menu = applicationContext.getBean("menu", Menu.class);
        Cart cart = applicationContext.getBean("cart", Cart.class);
        Order order = applicationContext.getBean("order", Order.class);

        // 2023.6.6(화) 23h30
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            // Spring 컨테이너가 관리하는 모든 Beans 조회 = Spring Framework가 내부적으로 사용하는 Beans + 내가 만든/등록한 Beans
//            Object bean = applicationContext.getBean(beanDefinitionName);
//            System.out.println("beanName = " + beanDefinitionName + ", object = " + bean);

            // Beans 메타정보 조회
//            BeanDefinition beanDefinition = applicationContext.getBeanDefinition(beanDefinitionName);
//            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
//                System.out.println("beanDefinitionName = " + beanDefinitionName + ", beanDefinition = " + beanDefinition);
//            }
        }

        // Spring 컨테이너 관리 하의 빈 객체들을 불러옴 -> 불러온 Bean 사용 = 의존성 주입 사용해서 해당 객체의 참조 값을 OrderApp 객체에 전달하여 프로그램 실행
        OrderApp orderApp = new OrderApp(
                productRepository,
                menu,
                cart,
                order
        );

        orderApp.view();

        // 2023.6.7(수) 23h30 Spring 컨테이너 종료
//        applicationContext.close();
    }
}
