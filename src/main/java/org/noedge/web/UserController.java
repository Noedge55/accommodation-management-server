package org.noedge.web;

import org.noedge.domain.Person;
import org.noedge.domain.Result;
import org.noedge.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.*;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 */
@RestController
public class UserController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/test")
    public Result test() throws ServletException, IOException {
        return Result.getResult(0,"测试惹",null);
    }

    @RequestMapping("/login")
    public Result login(HttpServletRequest request,@RequestParam Map map){
        String inputLoginId =(String) map.get("loginId");
        String inputPassword =(String) map.get("password");
        if(StringUtils.isEmpty(inputLoginId) || StringUtils.isEmpty(inputPassword)){
            return Result.getResult(-1,"用户名或者密码不能为空",null);
        }

        logger.info(inputLoginId + ":" +inputPassword);
        Person person = personService.getAllInfoByLoginId(inputLoginId);
        if(ObjectUtils.isEmpty(person)){
            return Result.getResult(-2,"不存在该用户",null);
        }

        //输入密码进行Base64解密
        inputPassword = new String(Base64Utils.decodeFromString(inputPassword));

        //获取盐
        String salt = person.getSalt();
        //计算实际密码 md5(password+salt)
        inputPassword = new String(DigestUtils.md5DigestAsHex((inputPassword+ "" + salt).getBytes()));

        logger.info(inputPassword);

        //获取表中实际密码
        String password = person.getPassword();
        if(!inputPassword.equals(password)){
            //登录失败
            return Result.getResult(-3,"用户名或者密码错误",null);
        }

        //将登录信息保存至Session
        String sessionId = request.getSession().getId();
        HttpSession session = request.getSession();
        session.setAttribute(sessionId,person);

        //封装返回对象
        Map<String,Object> resultData = new HashMap<String, Object>();
        resultData.put("id",person.getId());
        resultData.put("name",person.getName());
        resultData.put("group_id",person.getGroupId());
        return Result.getResult(1,"登录成功",resultData);
    }

}
