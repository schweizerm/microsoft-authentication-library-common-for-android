//  Copyright (c) Microsoft Corporation.
//  All rights reserved.
//
//  This code is licensed under the MIT License.
//
//  Permission is hereby granted, free of charge, to any person obtaining a copy
//  of this software and associated documentation files(the "Software"), to deal
//  in the Software without restriction, including without limitation the rights
//  to use, copy, modify, merge, publish, distribute, sublicense, and / or sell
//  copies of the Software, and to permit persons to whom the Software is
//  furnished to do so, subject to the following conditions :
//
//  The above copyright notice and this permission notice shall be included in
//  all copies or substantial portions of the Software.
//
//  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
//  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
//  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
//  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
//  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
//  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
//  THE SOFTWARE.
package com.microsoft.identity.common.internal.broker;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import com.microsoft.identity.common.internal.providers.microsoft.MicrosoftTokenErrorResponse;

import java.util.ArrayList;

/**
 * Encapsulates the broker error result
 */
public class BrokerErrorResponse extends MicrosoftTokenErrorResponse implements Parcelable {

    private String mOAuthErrorMetadata;

    public BrokerErrorResponse() {

    }

    public BrokerErrorResponse(@NonNull final MicrosoftTokenErrorResponse microsoftTokenErrorResponse) {
        setError(microsoftTokenErrorResponse.getError());
        setSubError(microsoftTokenErrorResponse.getSubError());
        setErrorDescription(microsoftTokenErrorResponse.getErrorDescription());
        setErrorUri(microsoftTokenErrorResponse.getErrorUri());
        setErrorCodes(microsoftTokenErrorResponse.getErrorCodes());
        setTimeStamp(microsoftTokenErrorResponse.getTimeStamp());
        setTraceId(microsoftTokenErrorResponse.getTraceId());
        setCorrelationId(microsoftTokenErrorResponse.getCorrelationId());
        setStatusCode(microsoftTokenErrorResponse.getStatusCode());
        setResponseHeadersJson(microsoftTokenErrorResponse.getResponseHeadersJson());
        setResponseBody(microsoftTokenErrorResponse.getResponseBody());
    }

    protected BrokerErrorResponse(Parcel in) {
        if (in != null) {
            setError(in.readString());
            setSubError(in.readString());
            setErrorDescription(in.readString());
            setErrorUri(in.readString());
            ArrayList errorcodes = new ArrayList();
            in.readList(errorcodes, ArrayList.class.getClassLoader());
            setErrorCodes(errorcodes);
            setTimeStamp(in.readString());
            setTraceId(in.readString());
            setCorrelationId(in.readString());
            setOAuthErrorMetadata(in.readString());
            setStatusCode(in.readInt());
            setResponseHeadersJson(in.readString());
            setResponseBody(in.readString());
        }
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (dest != null) {
            dest.writeString(getError());
            dest.writeString(getSubError());
            dest.writeString(getErrorDescription());
            dest.writeString(getErrorUri());
            dest.writeList(getErrorCodes());
            dest.writeString(getTimeStamp());
            dest.writeString(getTraceId());
            dest.writeString(getCorrelationId());
            dest.writeString(getOAuthErrorMetadata());
            dest.writeInt(getStatusCode());
            dest.writeString(getResponseHeadersJson());
            dest.writeString(getResponseBody());
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<BrokerErrorResponse> CREATOR = new Creator<BrokerErrorResponse>() {
        @Override
        public BrokerErrorResponse createFromParcel(Parcel in) {
            return new BrokerErrorResponse(in);
        }

        @Override
        public BrokerErrorResponse[] newArray(int size) {
            return new BrokerErrorResponse[size];
        }
    };

    public String getOAuthErrorMetadata() {
        return mOAuthErrorMetadata;
    }

    public void setOAuthErrorMetadata(String oAuthErrorMetadata) {
        this.mOAuthErrorMetadata = oAuthErrorMetadata;
    }
}
