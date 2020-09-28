package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RateDiscountPolicyTest {

    DiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("vip 는 10프로 할인된다")
    void vip_o(){
        //given
        Member member = new Member(1L,"memberVIP", Grade.VIP);

        //when
        int discount = discountPolicy.disCount(member, 10000);

        //then
        Assertions.assertEquals(discount,1000);
    }

    @Test
    @DisplayName("vip 가 아니면 할인이 안된다")
    void vip_x(){
        //given
        Member member = new Member(1L,"memberBASIC", Grade.BASIC);

        //when
        int discount = discountPolicy.disCount(member, 10000);

        //then
        org.assertj.core.api.Assertions.assertThat(discount).isEqualTo(0);
    }

}