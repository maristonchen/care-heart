package com.biocare.common.utils;

import com.biocare.common.em.ErrorCode;
import com.biocare.common.em.GlobalErrorCode;
import com.biocare.common.exception.BioException;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.Map;

/**
 * 参数验证工具
 *
 * @author mariston
 * @version V1.0
 * @since 2016/11/10
 */
public abstract class BioAssert {

    /**
     * Assert a boolean expression, throwing {@code BioException}
     * if the test result is {@code false}.
     * <pre class="code">Assert.isTrue(i &gt; 0, "The value must be greater than zero");</pre>
     *
     * @param expression a boolean expression
     * @param ErrorCode  the exception message {@code ErrorCode} to use if the assertion fails
     * @throws BioException if expression is {@code false}
     */
    public static void isTrue(boolean expression, ErrorCode ErrorCode) {
        if (!expression) {
            throw BioException.create(ErrorCode);
        }
    }

    /**
     * Assert that an object is {@code null} .
     * <pre class="code">Assert.isNull(value, "The value must be null");</pre>
     *
     * @param object    the object to check
     * @param ErrorCode the exception message {@code ErrorCode} to use if the assertion fails
     * @throws BioException if the object is not {@code null}
     */
    public static void isNull(Object object, ErrorCode ErrorCode) {
        if (object != null) {
            throw BioException.create(ErrorCode);
        }
    }

    /**
     * Assert that an object is not {@code null} .
     * <pre class="code">Assert.notNull(clazz, "The class must not be null");</pre>
     *
     * @param object    the object to check
     * @param ErrorCode the exception message {@code ErrorCode} to use if the assertion fails
     * @throws BioException if the object is {@code null}
     */
    public static void notNull(Object object, ErrorCode ErrorCode) {
        if (object == null) {
            throw BioException.create(ErrorCode);
        }
    }

    /**
     * Assert that the given String is not empty; that is,
     * it must not be {@code null} and not the empty String.
     * <pre class="code">Assert.hasLength(name, "Name must not be empty");</pre>
     *
     * @param text      the String to check
     * @param ErrorCode the exception message {@code ErrorCode} to use if the assertion fails
     * @throws BioException if the text is empty
     * @see StringUtils#hasLength
     */
    public static void hasLength(String text, ErrorCode ErrorCode) {
        if (!StringUtils.hasLength(text)) {
            throw BioException.create(ErrorCode);
        }
    }

    /**
     * Assert that the given String has valid text content; that is, it must not
     * be {@code null} and must contain at least one non-whitespace character.
     * <pre class="code">Assert.hasText(name, "'name' must not be empty");</pre>
     *
     * @param text      the String to check
     * @param ErrorCode the exception message {@code ErrorCode} to use if the assertion fails
     * @throws BioException if the text does not contain valid text content
     * @see StringUtils#hasText
     */
    public static void hasText(String text, ErrorCode ErrorCode) {
        if (!StringUtils.hasText(text)) {
            throw BioException.create(ErrorCode);
        }
    }

    /**
     * Assert that the given text does not contain the given substring.
     * <pre class="code">Assert.doesNotContain(name, "rod", "Name must not contain 'rod'");</pre>
     *
     * @param textToSearch the text to search
     * @param substring    the substring to find within the text
     * @param ErrorCode    the exception message to use if the assertion fails
     * @throws BioException if the text contains the substring
     */
    public static void doesNotContain(String textToSearch, String substring, ErrorCode ErrorCode) {
        if (StringUtils.hasLength(textToSearch) && StringUtils.hasLength(substring) && textToSearch.contains(substring)) {
            throw BioException.create(ErrorCode);
        }
    }

    /**
     * Assert that an array has elements; that is, it must not be
     * {@code null} and must have at least one element.
     * <pre class="code">Assert.notEmpty(array, "The array must have elements");</pre>
     *
     * @param array     the array to check
     * @param ErrorCode the exception message to use if the assertion fails
     * @throws BioException if the object array is {@code null} or has no elements
     */
    public static void notEmpty(Object[] array, ErrorCode ErrorCode) {
        if (ObjectUtils.isEmpty(array)) {
            throw BioException.create(ErrorCode);
        }
    }

    /**
     * Assert that an array has no null elements.
     * Note: Does not complain if the array is empty!
     * <pre class="code">Assert.noNullElements(array, "The array must have non-null elements");</pre>
     *
     * @param array     the array to check
     * @param ErrorCode the exception message to use if the assertion fails
     * @throws BioException if the object array contains a {@code null} element
     */
    public static void noNullElements(Object[] array, ErrorCode ErrorCode) {
        if (array != null) {
            for (Object element : array) {
                if (element == null) {
                    throw BioException.create(ErrorCode);
                }
            }
        }
    }

    /**
     * Assert that a collection has elements; that is, it must not be
     * {@code null} and must have at least one element.
     * <pre class="code">Assert.notEmpty(collection, "Collection must have elements");</pre>
     *
     * @param collection the collection to check
     * @param ErrorCode  the exception message to use if the assertion fails
     * @throws BioException if the collection is {@code null} or has no elements
     */
    public static void notEmpty(Collection<?> collection, ErrorCode ErrorCode) {
        if (CollectionUtils.isEmpty(collection)) {
            throw BioException.create(ErrorCode);
        }
    }

    /**
     * Assert that a Map has entries; that is, it must not be {@code null}
     * and must have at least one entry.
     * <pre class="code">Assert.notEmpty(map, "Map must have entries");</pre>
     *
     * @param map       the map to check
     * @param ErrorCode the exception message to use if the assertion fails
     * @throws BioException if the map is {@code null} or has no entries
     */
    public static void notEmpty(Map<?, ?> map, ErrorCode ErrorCode) {
        if (CollectionUtils.isEmpty(map)) {
            throw BioException.create(ErrorCode);
        }
    }


    /**
     * Assert that the provided object is an instance of the provided class.
     * <pre class="code">Assert.instanceOf(Foo.class, foo);</pre>
     *
     * @param type      the type to check against
     * @param obj       the object to check
     * @param ErrorCode a message which will be prepended to the message produced by
     *                  the function itself, and which may be used to provide context. It should
     *                  normally end in ":" or "." so that the generated message looks OK when
     *                  appended to it.
     * @throws BioException if the object is not an instance of clazz
     * @see Class#isInstance
     */
    public static void isInstanceOf(Class<?> type, Object obj, ErrorCode ErrorCode) {
        notNull(type, GlobalErrorCode.OBJECT_PARAM_NULL);
        if (!type.isInstance(obj)) {
            throw BioException.create(ErrorCode);
        }
    }

    /**
     * Assert that {@code superType.isAssignableFrom(subType)} is {@code true}.
     * <pre class="code">Assert.isAssignable(Number.class, myClass);</pre>
     *
     * @param superType the super type to check against
     * @param subType   the sub type to check
     * @param ErrorCode a message which will be prepended to the message produced by
     *                  the function itself, and which may be used to provide context. It should
     *                  normally end in ":" or "." so that the generated message looks OK when
     *                  appended to it.
     * @throws BioException if the classes are not assignable
     */
    public static void isAssignable(Class<?> superType, Class<?> subType, ErrorCode ErrorCode) {
        notNull(superType, GlobalErrorCode.OBJECT_PARAM_NULL);
        if (subType == null || !superType.isAssignableFrom(subType)) {
            throw BioException.create(ErrorCode);
        }
    }

}
