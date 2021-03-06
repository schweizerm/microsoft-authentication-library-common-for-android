// Copyright (c) Microsoft Corporation.
// All rights reserved.
//
// This code is licensed under the MIT License.
//
// Permission is hereby granted, free of charge, to any person obtaining a copy
// of this software and associated documentation files(the "Software"), to deal
// in the Software without restriction, including without limitation the rights
// to use, copy, modify, merge, publish, distribute, sublicense, and / or sell
// copies of the Software, and to permit persons to whom the Software is
// furnished to do so, subject to the following conditions :
//
// The above copyright notice and this permission notice shall be included in
// all copies or substantial portions of the Software.
//
// THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
// IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
// FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
// AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
// LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
// OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
// THE SOFTWARE.
package com.microsoft.identity.common.internal.providers.oauth2;

/**
 * Class to encapsulate Authorization Result errors.
 */
public class AuthorizationErrorResponse implements IErrorResponse{

    private String mError;
    private String mErrorDescription;

    /**
     * Constructor of {@link AuthorizationErrorResponse}.
     *
     * @param error            error returned due to Authorization request failure.
     * @param errorDescription error description returned due to Authorization request failure.
     */
    public AuthorizationErrorResponse(final String error, final String errorDescription) {
        mError = error;
        mErrorDescription = errorDescription;
    }

    /**
     * Getter method for error.
     *
     * @return error
     */
    public String getError() {
        return mError;
    }


    /**
     * Setter method for error.
     *
     * @param error error returned due to Authorization request failure.
     */
    public void setError(final String error) {
        mError = error;
    }

    /**
     * Getter method for error description.
     *
     * @return errorDescription
     */
    public String getErrorDescription() {
        return mErrorDescription;
    }


    /**
     * Setter method for error description.
     *
     * @param errorDescription error description returned due to Authorization request failure.
     */
    public void setErrorDescription(final String errorDescription) {
        mErrorDescription = errorDescription;
    }

    public static class Fields {
        public final static String ERROR = "error";
        public final static String ERROR_DESCRIPTION = "error_description";
    }
}
