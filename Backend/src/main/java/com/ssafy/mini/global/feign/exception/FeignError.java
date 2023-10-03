package com.ssafy.mini.global.feign.exception;

import com.ssafy.mini.global.exception.ErrorCode;
import com.ssafy.mini.global.exception.MNException;
import feign.Response;
import feign.codec.ErrorDecoder;

public class FeignError implements ErrorDecoder {
    @Override
    public Exception decode(String methodKey, Response response) {
        switch (response.status()) {
            case 404:
                return new MNException(ErrorCode.NO_SUCH_STOCK);
        }
        return null;
    }
}
