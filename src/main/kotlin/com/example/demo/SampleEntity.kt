package com.example.demo

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.SequenceGenerator
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Entity(name = "Sample")
data class SampleEntity(
    @field:Id
    @SequenceGenerator(name = "sample_seq", sequenceName = "hibernate_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sample_seq")
    val id: Long = 0,
    val name: String,
    val family: String,
)

interface SampleRepository: JpaRepository<SampleEntity, Long>

@Service
class SampleService(private val sampleRepository: SampleRepository) {
    fun create() {
        sampleRepository.save(SampleEntity(name = "Siavash", family = "Soleymani"))
    }

    @Transactional
    fun transactionalCreate() {
        sampleRepository.save(SampleEntity(name = "Siavash", family = "Soleymani"))
    }

    fun createAtOnce() {
        val list = arrayListOf<SampleEntity>()
        for (i in 1..20) {
            list.add(SampleEntity(name = "Siavash", family = "Soleymani"))
        }
        sampleRepository.saveAll(list)
    }

    @Transactional
    fun transactionalCreateAtOnce() {
        val list = arrayListOf<SampleEntity>()
        for (i in 1..20) {
            list.add(SampleEntity(name = "Siavash", family = "Soleymani"))
        }
        sampleRepository.saveAll(list)
    }

    fun batchCreate() {
        for (i in 1..20) {
            sampleRepository.save(SampleEntity(name = "Siavash", family = "Soleymani"))
        }
    }

    @Transactional
    fun transactionalBatchCreate() {
        for (i in 1..20) {
            sampleRepository.save(SampleEntity(name = "Siavash", family = "Soleymani"))
        }
    }
}
