package com.dt.project.config;

/**
 * @ClassName RedisConfig
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/4/25 14:33
 **/
//@Configuration
public class RedisConfig {

//
//    @Bean
//    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory){
//        RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();
//        redisTemplate.setConnectionFactory(factory);
//        // 使用Jackson2JsonRedisSerialize 替换默认序列化
//        /**Jackson序列化  json占用的内存最小 */
//        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
//        ObjectMapper om = new ObjectMapper();
//        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
//        jackson2JsonRedisSerializer.setObjectMapper(om);
//        /**Jdk序列化   JdkSerializationRedisSerializer是最高效的*/
////      JdkSerializationRedisSerializer jdkSerializationRedisSerializer = new JdkSerializationRedisSerializer();
//        /**String序列化*/
//        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
//        /**将key value 进行stringRedisSerializer序列化*/
//        redisTemplate.setKeySerializer(stringRedisSerializer);
//        redisTemplate.setValueSerializer(stringRedisSerializer);
//        /**将HashKey HashValue 进行序列化*/
//        redisTemplate.setHashKeySerializer(stringRedisSerializer);
//        redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);
//        redisTemplate.afterPropertiesSet();
//
//        return redisTemplate;
//    }
}
