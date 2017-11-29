/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
/*
 * This code was generated by https://github.com/google/apis-client-generator/
 * (build: 2017-11-07 19:12:12 UTC)
 * on 2017-11-21 at 20:11:24 UTC 
 * Modify at your own risk.
 */

package com.videogames_api.model;

/**
 * Model definition for MessagesVideogameInput.
 *
 * <p> This is the Java data model class that specifies how to parse/serialize into the JSON that is
 * transmitted over HTTP when working with the videogames_api. For a detailed explanation see:
 * <a href="https://developers.google.com/api-client-library/java/google-http-java-client/json">https://developers.google.com/api-client-library/java/google-http-java-client/json</a>
 * </p>
 *
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public final class MessagesVideogameInput extends com.google.api.client.json.GenericJson {

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String description;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String developer;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String genre;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String image;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String publisher;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String title;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String token;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key("user_key")
  private java.lang.String userKey;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String year;

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getDescription() {
    return description;
  }

  /**
   * @param description description or {@code null} for none
   */
  public MessagesVideogameInput setDescription(java.lang.String description) {
    this.description = description;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getDeveloper() {
    return developer;
  }

  /**
   * @param developer developer or {@code null} for none
   */
  public MessagesVideogameInput setDeveloper(java.lang.String developer) {
    this.developer = developer;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getGenre() {
    return genre;
  }

  /**
   * @param genre genre or {@code null} for none
   */
  public MessagesVideogameInput setGenre(java.lang.String genre) {
    this.genre = genre;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getImage() {
    return image;
  }

  /**
   * @param image image or {@code null} for none
   */
  public MessagesVideogameInput setImage(java.lang.String image) {
    this.image = image;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getPublisher() {
    return publisher;
  }

  /**
   * @param publisher publisher or {@code null} for none
   */
  public MessagesVideogameInput setPublisher(java.lang.String publisher) {
    this.publisher = publisher;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getTitle() {
    return title;
  }

  /**
   * @param title title or {@code null} for none
   */
  public MessagesVideogameInput setTitle(java.lang.String title) {
    this.title = title;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getToken() {
    return token;
  }

  /**
   * @param token token or {@code null} for none
   */
  public MessagesVideogameInput setToken(java.lang.String token) {
    this.token = token;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getUserKey() {
    return userKey;
  }

  /**
   * @param userKey userKey or {@code null} for none
   */
  public MessagesVideogameInput setUserKey(java.lang.String userKey) {
    this.userKey = userKey;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getYear() {
    return year;
  }

  /**
   * @param year year or {@code null} for none
   */
  public MessagesVideogameInput setYear(java.lang.String year) {
    this.year = year;
    return this;
  }

  @Override
  public MessagesVideogameInput set(String fieldName, Object value) {
    return (MessagesVideogameInput) super.set(fieldName, value);
  }

  @Override
  public MessagesVideogameInput clone() {
    return (MessagesVideogameInput) super.clone();
  }

}