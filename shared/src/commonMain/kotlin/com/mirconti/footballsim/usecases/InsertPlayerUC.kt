package com.mircontapp.sportalbum.domain.usecases

import com.mircontapp.sportalbum.domain.models.PlayerModel
import com.mircontapp.sportalbum.domain.repository.PlayersRepository
import javax.inject.Inject

class InsertPlayerUC @Inject constructor(val playerRepository: PlayersRepository) {
    operator suspend fun invoke(playerModel: PlayerModel) {
        playerRepository.insertPlayer(playerModel)
    }
}