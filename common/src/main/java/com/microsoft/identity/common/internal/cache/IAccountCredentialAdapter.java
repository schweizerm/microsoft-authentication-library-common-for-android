package com.microsoft.identity.common.internal.cache;

import com.microsoft.identity.common.internal.dto.AccessToken;
import com.microsoft.identity.common.internal.dto.Account;
import com.microsoft.identity.common.internal.dto.IdToken;
import com.microsoft.identity.common.internal.dto.RefreshToken;
import com.microsoft.identity.common.internal.providers.oauth2.AuthorizationRequest;
import com.microsoft.identity.common.internal.providers.oauth2.OAuth2Strategy;
import com.microsoft.identity.common.internal.providers.oauth2.TokenResponse;

/**
 * Provides Adapters to the MsalOAuth2TokenCache.
 */
public interface IAccountCredentialAdapter {

    Account createAccount(OAuth2Strategy strategy,
                          AuthorizationRequest request,
                          TokenResponse response
    );

    AccessToken createAccessToken(OAuth2Strategy strategy,
                                  AuthorizationRequest request,
                                  TokenResponse response
    );

    RefreshToken createRefreshToken(OAuth2Strategy strategy,
                                    AuthorizationRequest request,
                                    TokenResponse response
    );

    IdToken createIdToken(OAuth2Strategy strategy,
                          AuthorizationRequest request,
                          TokenResponse response
    );

    RefreshToken asRefreshToken(com.microsoft.identity.common.internal.providers.oauth2.RefreshToken refreshToken);

    Account asAccount(com.microsoft.identity.common.Account account);

    IdToken asIdToken(com.microsoft.identity.common.Account account,
                      com.microsoft.identity.common.internal.providers.oauth2.RefreshToken refreshToken
    );
}