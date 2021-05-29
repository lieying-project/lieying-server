package org.lieying.core;
import com.alibaba.fastjson.JSON;
import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult {

    private Integer code;
    private String message;
    private Object data;

    public CommonResult(Integer code,String message){
        this.code = code;
        this.message = message;
    }

    public CommonResult setCode(Integer code) {
        this.code = code;
        return this;
    }

    public CommonResult setMessage(String message) {
        this.message = message;
        return this;
    }

    public CommonResult setData(Object data) {
        this.data = data;
        return this;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

}
