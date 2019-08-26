package org.noedge.web;

import org.noedge.domain.Person;
import org.noedge.domain.Result;
import org.noedge.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Base64Utils;
import org.springframework.util.DigestUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * @Description:
 */
@Controller
public class UserController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/test")
    public void test(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        PrintWriter out = null;
//        String data = "{\"name\":\"舞蹈家\"}";
//        try {
//            out = response.getWriter();
//            out.write(data);
//        }catch (Exception e){
//            e.printStackTrace();
//        }finally {
//            out.flush();
//            out.close();
//        }
//        modelMap.addAttribute("data",data);
//        return "jsonData";
    }

    @RequestMapping("/login")
    @ResponseBody
    public Result login(HttpServletRequest request, HttpServletResponse response,@RequestParam Map map){
        Result result = new Result();
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
        inputPassword = new String(DigestUtils.md5Digest((inputPassword+ "" + salt).getBytes()));

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

        clearPersonSensitiveInfo(person);
        return Result.getResult(1,"登录成功",person);
    }

    private void clearPersonSensitiveInfo(Person person) {
        person.setPassword("");
        person.setSalt("");
        person.setEmail("");
        person.setPhone("");
    }
}
