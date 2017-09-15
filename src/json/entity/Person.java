//******************************************************************************
// 版权所有(c) 2017，科大国创软件股份有限公司，保留所有权利。
//******************************************************************************

package json.entity;

/**
 * person类
 * @author mabing
 */
public class Person {
    private String name = "";
    private String age = "";
    private String mail = "";
    private Integer sex ;
    /**
     * mail的GET方法.
     *
     * @return mail
     */
    public String getMail() {
        return mail;
    }
    /**
     * mail的SET方法.
     *
     * @param mail mail
     */
    public void setMail(String mail) {
        this.mail = mail;
    }
    /**
     * sex的GET方法.
     *
     * @return sex
     */
    public Integer getSex() {
        return sex;
    }
    /**
     * sex的SET方法.
     *
     * @param sex sex
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }
    /**
     * name的GET方法.
     *
     * @return name
     */
    public String getName() {
        return name;
    }
    /**
     * name的SET方法.
     *
     * @param name name
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * age的GET方法.
     *
     * @return age
     */
    public String getAge() {
        return age;
    }
    /**
     * age的SET方法.
     *
     * @param age age
     */
    public void setAge(String age) {
        this.age = age;
    }
    
}
